package br.com.bsi.pi.ticketsbsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bsi.pi.ticketsbsi.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
