package br.com.bsi.pi.ticketsbsi.repositories;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
