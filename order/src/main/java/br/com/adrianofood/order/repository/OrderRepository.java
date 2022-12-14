package br.com.adrianofood.order.repository;

import br.com.adrianofood.order.domain.Order;
import br.com.adrianofood.order.domain.Status;
import br.com.adrianofood.order.domain.dto.response.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT new  br.com.adrianofood.order.domain.dto.response.OrderResponse(o.orderId, o.dateTime, o.status, o.itemOrderId) FROM Order o")
    List<OrderResponse> listAllOrder();

    @Query("SELECT new  br.com.adrianofood.order.domain.dto.response.OrderResponse(o.orderId, o.dateTime, o.status, o.itemOrderId) FROM Order o WHERE o.status=:status")
    Optional<OrderResponse> findByStatus(@Param("status") Status status);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Order p set p.status = :status where p = :order")
    void atualizaStatus(Status status, Order order);
}
