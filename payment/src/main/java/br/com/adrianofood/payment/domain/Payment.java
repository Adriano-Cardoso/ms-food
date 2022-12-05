package br.com.adrianofood.payment.domain;

import br.com.adrianofood.payment.domain.dto.request.PaymentRequest;
import br.com.adrianofood.payment.domain.dto.response.PaymentResponse;
import br.com.adrianofood.payment.domain.enums.Status;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "value_payment")
    private BigDecimal value;

    @Column(name = "name")
    private String name;

    @Column(name = "number_payment")
    private String number;

    @Column(name = "expiration")
    private String expiration;

    @Column(name = "code")
    private String code;

    @Column(name = "status_payment")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "payment_form_id")
    private Long paymentFormId;

    public static Payment of(PaymentRequest paymentRequest) {
        return Payment.builder()
                .value(paymentRequest.getValue())
                .name(paymentRequest.getName())
                .number(paymentRequest.getNumber())
                .expiration(paymentRequest.getExpiration())
                .code(paymentRequest.getCode())
                .status(paymentRequest.getStatus())
                .orderId(paymentRequest.getOrderId())
                .paymentFormId(paymentRequest.getPaymentFormId()).build();
    }

    public PaymentResponse toResponse() {
        return PaymentResponse.builder()
                .paymentId(this.paymentId)
                .name(this.name)
                .value(this.value)
                .number(this.number)
                .expiration(this.expiration)
                .code(this.code)
                .status(this.status)
                .orderId(this.orderId)
                .paymentFormId(this.paymentFormId).build();
    }

    public void update(PaymentRequest paymentRequest) {
        this.name = paymentRequest.getName();

    }
}
