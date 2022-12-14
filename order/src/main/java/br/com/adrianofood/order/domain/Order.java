package br.com.adrianofood.order.domain;

import br.com.adrianofood.order.domain.dto.request.OrderRequest;
import br.com.adrianofood.order.domain.dto.request.StatusRequest;
import br.com.adrianofood.order.domain.dto.response.OrderResponse;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "item_id", nullable = true, insertable = false, updatable = false)
    private Long itemOrderId;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private List<ItemOrder> itemOrders;

    @PrePersist
    public void prePersist() {
        this.dateTime = LocalDateTime.now();
    }

    public static Order of(OrderRequest orderRequest) {
        return Order.builder().dateTime(orderRequest.getDateTime())
                .status(orderRequest.getStatus()).build();
    }

    public OrderResponse toResponse() {
        return OrderResponse.builder()
                .orderId(this.orderId)
                .dateTime(this.dateTime)
                .status(this.status)
                .itemOrderId(this.itemOrderId).build();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        this.itemOrders = new ArrayList<ItemOrder>();
        this.itemOrders.add(itemOrder);
    }

    public void setStatusRealized(Status status) {
        Order order = new Order();
        order.setStatus(Status.REALIZADO);
    }

    public void updateStatus(StatusRequest status) {
        Order order = new Order();
        this.status = status.getStatus();
    }


}
