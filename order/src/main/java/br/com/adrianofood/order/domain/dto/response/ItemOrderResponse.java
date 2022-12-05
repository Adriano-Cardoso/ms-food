package br.com.adrianofood.order.domain.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrderResponse {

    private Long itemOrderId;
    private Integer amount;
    private String description;
}
