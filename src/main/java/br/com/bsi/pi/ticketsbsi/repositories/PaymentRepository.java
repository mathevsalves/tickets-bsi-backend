package br.com.bsi.pi.ticketsbsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bsi.pi.ticketsbsi.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
