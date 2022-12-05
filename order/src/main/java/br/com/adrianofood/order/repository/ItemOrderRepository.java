package br.com.adrianofood.order.repository;

import br.com.adrianofood.order.domain.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
}
