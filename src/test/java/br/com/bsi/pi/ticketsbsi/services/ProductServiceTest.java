package br.com.bsi.pi.ticketsbsi.services;

import java.util.ArrayList;
import java.util.Optional;

import br.com.bsi.pi.ticketsbsi.entities.User;
import br.com.bsi.pi.ticketsbsi.repositories.UserRepository;
import br.com.bsi.pi.ticketsbsi.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.repositories.ProductRepository;

import javax.persistence.EntityNotFoundException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    private ProductRepository repository = Mockito.mock(ProductRepository.class);

    private ProductService service;

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

        Optional optional = Mockito.mock(Optional.class);

        Mockito.when(repository.findById(id)).thenReturn(optional);

        Mockito.when(optional.get()).thenReturn(new Product());

        var service = new ProductService(repository);

        var result = service.findById(id);

        Assertions.assertNotNull(result);
    }

    @Test
    void findAllIsPrevious() {
    }

    @Test
    void insert() {
        final Product product = new Product();

        Product p = mock(Product.class);

        when(repository.save(product)).thenReturn(p);

        var result = service.insert(product);

        Assertions.assertNotNull(result);
    }

    @Test
    void delete() {
    }

    @Test
    void update() {

        final Product product = new Product();

        Product p = mock(Product.class);

        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(p);

        when(repository.findById(Mockito.anyLong())).thenReturn(optional);

        when(repository.save(product)).thenReturn(p);

        var result = service.update(1L, product);

        Assertions.assertNotNull(result);
    }


    @Test
    void updateWithThrow() {

        final Product product = new Product();

        Product p = mock(Product.class);

        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(p);

        when(repository.findById(Mockito.anyLong())).thenThrow(new EntityNotFoundException("error"));

        when(repository.save(product)).thenReturn(p);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.update(1L, product));
    }
}
