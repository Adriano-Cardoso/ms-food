package br.com.adrianofood.order.amqp;

import br.com.adrianofood.order.domain.dto.PaymentDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMensagem(PaymentDto paymentDto){

        String message = """
                Nome: %s
                Dados do pagemnto: %s
                Número do pedido: %s
                Valor R$: %s
                Status %s
                """.formatted(
                        paymentDto.getName(),
                        paymentDto.getPaymentId(),
                        paymentDto.getOrderId(),
                        paymentDto.getValue(),
                        paymentDto.getStatusPayment());

        System.out.println("Recebi a messagem " + message.toString());
    }

}
