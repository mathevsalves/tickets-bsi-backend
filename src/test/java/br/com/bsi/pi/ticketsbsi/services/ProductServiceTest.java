package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    ProductRepository productRepository = Mockito.mock(ProductRepository.class);

    @Test
    void findAll() {
        Mockito.when(productRepository.findAll()).thenReturn(new ArrayList<>());

        var service = new ProductService(productRepository);

        var result = service.findAll();

        Assertions.assertNotNull(result);
    }

    @Test
    void findById() {

        Long id = 1L;

        Optional optional = Mockito.mock(Optional.class);

        Mockito.when(productRepository.findById(id)).thenReturn(optional);

        Mockito.when(optional.get()).thenReturn(new Product());

        var service = new ProductService(productRepository);

        var result = service.findById(id);

        Assertions.assertNotNull(result);
    }

}
