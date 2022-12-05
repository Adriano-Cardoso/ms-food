package br.com.adrianofood.order.service;

import br.com.adrianofood.order.domain.ItemOrder;
import br.com.adrianofood.order.domain.Order;
import br.com.adrianofood.order.domain.Status;
import br.com.adrianofood.order.domain.dto.request.OrderRequest;
import br.com.adrianofood.order.domain.dto.request.StatusRequest;
import br.com.adrianofood.order.domain.dto.response.OrderResponse;
import br.com.adrianofood.order.exception.Message;
import br.com.adrianofood.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    private ItemOrderService itemOrderService;


    public List<OrderResponse> listAllOrder() {
        return orderRepository.listAllOrder();
    }

    public OrderResponse findByIdOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(Message.ID_ORDER_NOT_FOUND::asBusinessException);

        return order.toResponse();
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {

//        this.orderRepository.findByStatus(orderRequest.getStatus()).ifPresent(s -> {
//            throw Message.ORDER_EXISTS.asBusinessException();
//        });

        ItemOrder itemOrder = this.itemOrderService.findById(orderRequest.getItemOrderId());

        Order order = Order.of(orderRequest);

        order.addItemOrder(itemOrder);

        order.setStatusRealized(Status.REALIZADO);

        this.orderRepository.save(order);

        return order.toResponse();
    }

    public OrderResponse updateStatus(Long orderId, StatusRequest statusRequest) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(Message.ID_ORDER_NOT_FOUND::asBusinessException);

        order.updateStatus(statusRequest);

        return order.toResponse();
    }

    public void approvePaymentOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(Message.ID_ORDER_NOT_FOUND::asBusinessException);

        StatusRequest statusRequest = new StatusRequest();

        statusRequest.setStatus(Status.PAGO);

        order.updateStatus(statusRequest);
    }
}
