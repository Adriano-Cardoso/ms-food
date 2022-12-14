package br.com.adrianofood.order.controller;

import br.com.adrianofood.order.domain.dto.request.OrderRequest;
import br.com.adrianofood.order.domain.dto.request.StatusRequest;
import br.com.adrianofood.order.domain.dto.response.OrderResponse;
import br.com.adrianofood.order.service.OrderService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
@Api(value = "Order Endpoints", description = "Order", tags = {"Order Endpoint"})
public class OrderController {

    private OrderService orderService;


    @GetMapping("/list")
    public ResponseEntity<List<OrderResponse>> listAllOrder() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.listAllOrder());
    }

    @GetMapping("/port")
    public String returnPort(@Value("${local.server.port}") String port){
        return String.format("Requisição respondida pela instância executando na porta %s", port);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> findByIdOrder(@PathVariable("orderId") @NotNull Long orderId) {
        ;
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findByIdOrder(orderId));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Valid OrderRequest orderRequest, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(orderRequest));

    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderResponse> updateStatus(@PathVariable("orderId") Long orderId, @RequestBody StatusRequest statusRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateStatus(orderId, statusRequest));
    }


    @PutMapping("/{orderId}/pago")
    public ResponseEntity<Void> approvePaymentOrder(@PathVariable("orderId") @NotNull Long orderId) {
        orderService.approvePaymentOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
