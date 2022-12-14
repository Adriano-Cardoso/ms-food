package br.com.adrianofood.order.domain;

import lombok.Getter;

@Getter
public enum Status {
    REALIZADO,
    CANCELADO,
    PAGO,
    NAO_AUTORIZADO,
    CONFIRMED,
    PRONTO,
    SAIU_PARA_ENTREGA,
    ENTREGUE;
}
