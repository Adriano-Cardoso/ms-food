package br.com.adrianofood.order.domain.dto.request;

import br.com.adrianofood.order.domain.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private LocalDateTime dateTime;
    private Status status;
    private Long itemOrderId;



}
