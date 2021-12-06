package br.com.bsi.pi.ticketsbsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bsi.pi.ticketsbsi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
