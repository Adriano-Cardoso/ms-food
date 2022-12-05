package br.com.adrianofood.order.domain.dto.response;

import br.com.adrianofood.order.domain.Status;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {
    private Status status;
}
