package br.com.adrianofood.order.repository;

import br.com.adrianofood.order.domain.Order;
import br.com.adrianofood.order.domain.Status;
import br.com.adrianofood.order.domain.dto.response.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT new  br.com.adrianofood.order.domain.dto.response.OrderResponse(o.orderId, o.dateTime, o.status, o.itemOrderId) FROM Order o")
    List<OrderResponse> listAllOrder();

    @Query("SELECT new  br.com.adrianofood.order.domain.dto.response.OrderResponse(o.orderId, o.dateTime, o.status, o.itemOrderId) FROM Order o WHERE o.status=:status")
    Optional<OrderResponse> findByStatus(@Param("status") Status status);
}
