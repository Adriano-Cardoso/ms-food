package br.com.adrianofood.payment.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "pedidos-ms")
public interface OrderClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/order/{orderId}/pago")
    void updatePayment(@PathVariable("orderId") Long orderId);

}
