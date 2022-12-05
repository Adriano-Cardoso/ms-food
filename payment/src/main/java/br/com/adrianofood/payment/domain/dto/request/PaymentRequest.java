package br.com.adrianofood.payment.domain.dto.request;

import br.com.adrianofood.payment.domain.enums.Status;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentRequest {

    private BigDecimal value;
    private String name;
    private String number;
    private String expiration;
    private String code;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long orderId;
    private Long paymentFormId;
}
