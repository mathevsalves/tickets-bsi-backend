package br.com.bsi.pi.ticketsbsi.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bsi.pi.ticketsbsi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByDateShowGreaterThan(Date date);
    List<Product> findByDateShowLessThan(Date date);
}
