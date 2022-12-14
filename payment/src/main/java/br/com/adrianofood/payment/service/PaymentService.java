package br.com.adrianofood.payment.service;

import br.com.adrianofood.payment.domain.Payment;
import br.com.adrianofood.payment.domain.dto.request.PaymentRequest;
import br.com.adrianofood.payment.domain.dto.response.PaymentResponse;
import br.com.adrianofood.payment.domain.enums.Status;
import br.com.adrianofood.payment.exception.Message;
import br.com.adrianofood.payment.http.OrderClient;
import br.com.adrianofood.payment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PaymentService {

    private PaymentRepository paymentRepository;

    private OrderClient orderClient;

    public PaymentResponse createPayment(PaymentRequest paymentRequest) {

        paymentRepository.findByName(paymentRequest.getName()).ifPresent(name -> {
            throw Message.NAME_EXISTS.asBusinessException();
        });

        Payment payment = Payment.of(paymentRequest);

        paymentRepository.save(payment);

        return payment.toResponse();
    }

    @Transactional
    public PaymentResponse updatePayment(Long paymentId, PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(Message.ID_PAYMENT_NOT_FOUND::asBusinessException);

        payment.update(paymentRequest);

        return payment.toResponse();
    }

    public Page<PaymentResponse> listAllPayments() {
        int limit = 3;
        int page = 0;

        Pageable pageable = PageRequest.of(page, limit);

        return paymentRepository.listAllPayment(pageable);
    }

    public PaymentResponse deletePayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(Message.ID_PAYMENT_NOT_FOUND::asBusinessException);

        paymentRepository.delete(payment);

        return payment.toResponse();
    }


    public PaymentResponse findByIdPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(Message.ID_PAYMENT_NOT_FOUND::asBusinessException);
        return payment.toResponse();
    }

    public void confirmPayment(Long orderId) {
        Payment payment = paymentRepository.findById(orderId)
                .orElseThrow(Message.ID_PAYMENT_NOT_FOUND::asBusinessException);
        payment.setStatus(Status.CONFIRMED);

        paymentRepository.save(payment);
        orderClient.updatePayment(payment.getOrderId());
    }


}
