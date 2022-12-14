package br.com.adrianofood.order.controller;

import br.com.adrianofood.order.domain.ItemOrder;
import br.com.adrianofood.order.domain.dto.request.OrderRequest;
import br.com.adrianofood.order.domain.dto.request.StatusRequest;
import br.com.adrianofood.order.domain.dto.response.OrderResponse;
import br.com.adrianofood.order.service.ItemOrderService;
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
@RequestMapping("/item")
@Api(value = "item Endpoints", description = "item", tags = {"item Endpoint"})
public class ItemController {

    private ItemOrderService orderService;


    @GetMapping("/{orderId}")
    public ResponseEntity<ItemOrder> findByIdOrder(@PathVariable @NotNull Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(orderId));
    }


}
