package br.com.adrianofood.order.domain.dto.request;

import br.com.adrianofood.order.domain.Status;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusRequest {
    private Status status;
}
