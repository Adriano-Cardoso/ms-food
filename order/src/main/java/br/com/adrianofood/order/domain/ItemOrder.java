package br.com.adrianofood.order.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "item_pedido")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @NotNull
    @Column(name = "amount")
    private Integer amount;

    @Column(name = "description")
    private String description;

}
