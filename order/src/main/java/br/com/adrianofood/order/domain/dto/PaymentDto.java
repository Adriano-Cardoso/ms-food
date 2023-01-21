package br.com.adrianofood.order.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {

    private Long paymentId;
    private BigDecimal value;
    private String name;
    private String number;
    private String expiration;
    private String code;
    @Enumerated(EnumType.STRING)
    private StatusPayment statusPayment;
    private Long orderId;
    private Long paymentFormId;
}
