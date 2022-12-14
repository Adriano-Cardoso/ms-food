package br.com.adrianofood.order.repository;

import br.com.adrianofood.order.domain.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
}
