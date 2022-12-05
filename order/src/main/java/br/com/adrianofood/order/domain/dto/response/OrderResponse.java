package br.com.adrianofood.order.domain.dto.response;

import br.com.adrianofood.order.domain.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long orderId;
    private LocalDateTime dateTime;
    private Status status;
    private Long itemOrderId;


}
