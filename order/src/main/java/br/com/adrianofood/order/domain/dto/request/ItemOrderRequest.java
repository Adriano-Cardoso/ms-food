package br.com.adrianofood.order.domain.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrderRequest {

    private Integer amount;
    private String description;
}
