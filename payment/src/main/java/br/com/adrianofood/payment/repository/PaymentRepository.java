package br.com.adrianofood.payment.repository;

import br.com.adrianofood.payment.domain.Payment;
import br.com.adrianofood.payment.domain.dto.response.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT new  br.com.adrianofood.payment.domain.dto.response.PaymentResponse(p.paymentId, p.value, p.name, p.number, p.expiration, p.code, p.status, p.orderId, p.paymentFormId) FROM Payment p")
    Page<PaymentResponse> listAllPayment(Pageable pageable);

    @Query("SELECT new  br.com.adrianofood.payment.domain.dto.response.PaymentResponse(p.paymentId, p.value, p.name, p.number, p.expiration, p.code, p.status, p.orderId, p.paymentFormId) FROM Payment p WHERE p.name=:name")
    Optional<Object> findByName(@Param("name") String name);
}
