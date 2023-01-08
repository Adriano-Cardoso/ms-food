package br.com.adrianofood.payment.controller;

import br.com.adrianofood.payment.domain.dto.request.PaymentRequest;
import br.com.adrianofood.payment.domain.dto.response.PaymentResponse;
import br.com.adrianofood.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
@Api(value = "Payment Endpoints", description = "Payment", tags = {"Payment Endpoint"})
public class PaymentController {

    private PaymentService paymentService;

    @ApiOperation(value = "Cria um novo pagamento")
    @PostMapping("/create")
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(paymentRequest));
    }

    @ApiOperation(value = "Atualiza o pagamento por nome")
    @PatchMapping("/update/{paymentId}")
    public ResponseEntity<PaymentResponse> updatePayment(@PathVariable("paymentId") Long paymentId, @RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.updatePayment(paymentId, paymentRequest));
    }

    @ApiOperation(value = "Busca pagamento por Id")
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponse> findByIdPayment(@PathVariable("paymentId") Long paymentId) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.findByIdPayment(paymentId));
    }

    @ApiOperation(value = "Deleta um pagamento por id")
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<PaymentResponse> deletePayment(@PathVariable("paymentId") Long paymentId) {
        paymentService.deletePayment(paymentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Busca todos os pagamentos por paginação")
    @GetMapping("/list")
    public ResponseEntity<Page<PaymentResponse>> listAllPayments() {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.listAllPayments());
    }

//    @ApiOperation(value = "envia confirmação de pagamento para o ms de pedido")
//    @PatchMapping("/{orderId}/confirmed")
//    public void confirmedPayment(@PathVariable("orderId") Long orderId) {
//        paymentService.confirmPayment(orderId);
//
//    }
}
