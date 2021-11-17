package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductRepository repository = Mockito.mock(ProductRepository.class);

    private ProductService productService;

    @BeforeEach
    public void setup() {
        productService = new ProductService(repository);
    }

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        var result = repository.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {
        final Long l = 1L;

        Product p = Mockito.mock(Product.class);

        Mockito.when(repository.findById(l)).thenReturn(java.util.Optional.ofNullable(p));

        var result = repository.findById(l);

        Assertions.assertNotNull(result);
    }
}
