package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.repositories.ProductRepository;
import br.com.bsi.pi.ticketsbsi.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    private final ProductRepository repository = mock(ProductRepository.class);

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        var service = new ProductService(repository);

        var result = service.findAll();

        Assertions.assertNotNull(result);
    }

    @Test
    void findById() {
        Long id = 1L;
        Optional optional = mock(Optional.class);

        when(repository.findById(id)).thenReturn(optional);

        when(optional.get()).thenReturn(new Product());

        var service = new ProductService(repository);

        var result = service.findById(id);

        Assertions.assertNotNull(result);
    }

    @Test
    void findAllIsPrevious() {
    }

    @Test
    void insert() {
        final Product productTest = new Product();
        Product product = mock(Product.class);

        when(repository.save(productTest)).thenReturn(product);

        var service = new ProductService(repository);

        var result = service.insert(productTest);

        Assertions.assertNotNull(result);
    }

    @Test
    void delete() {
        Long id = 1L;
        var service = new ProductService(repository);

        service.delete(id);
    }

    @Test
    void update() {
        final Product productTest = new Product();
        Product product = mock(Product.class);
        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(product);

        when(repository.findById(anyLong())).thenReturn(optional);

        when(repository.save(productTest)).thenReturn(product);

        var service = new ProductService(repository);

        var result = service.update(1L, productTest);

        Assertions.assertNotNull(result);
    }


    @Test
    void updateWithThrow() {
        final Product productTest = new Product();
        Product product = mock(Product.class);
        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(product);

        when(repository.findById(anyLong())).thenThrow(new EntityNotFoundException("error"));

        when(repository.save(productTest)).thenReturn(product);

        var service = new ProductService(repository);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.update(1L, productTest));
    }
}
