package br.com.adrianofood.order.service;

import br.com.adrianofood.order.domain.ItemOrder;
import br.com.adrianofood.order.exception.Message;
import br.com.adrianofood.order.repository.ItemOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ItemOrderService {

    private ItemOrderRepository itemOrderRepository;

    public ItemOrder findById(Long itemOrderId){
       return itemOrderRepository.findById(itemOrderId)
                .orElseThrow(Message.ID_ORDER_NOT_FOUND::asBusinessException);



    }
}
