package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;
import br.com.bsi.pi.ticketsbsi.repositories.PaymentRepository;
import br.com.bsi.pi.ticketsbsi.repositories.ProductRepository;
import br.com.bsi.pi.ticketsbsi.services.exceptions.DatabaseException;
import br.com.bsi.pi.ticketsbsi.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderServiceTest {

    private OrderRepository repository = mock(OrderRepository.class);

    private OrderService service;

    private PaymentRepository paymentRepository = mock(PaymentRepository.class);

    private ProductRepository productRepository = mock(ProductRepository.class);

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        var service = new OrderService(repository, paymentRepository, productRepository);

        var result = service.findAll();

        Assertions.assertNotNull(result);
    }

    @Test
    void findById() {

        Long id = 1L;

        Optional optional = mock(Optional.class);

        when(repository.findById(id)).thenReturn(optional);

        when(optional.orElseThrow()).thenReturn(new Order());

        var service = new OrderService(repository, paymentRepository, productRepository);

        var result = service.findById(id);

        Assertions.assertNull(result);

    }

    @Test
    void insert() {

        Product product = mock(Product.class);

        Product p = new Product();
        p.setPrice(100.0);
        p.setId(1L);

        Order o = new Order();
        o.setPrice(100.0);
        o.setProduct(p);
        o.setQuantity(5);

        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(product);

        when(productRepository.findById(anyLong())).thenReturn(optional);

        var service = new OrderService(repository, paymentRepository, productRepository);

        when(repository.save(any())).thenReturn(o);
        var result = service.insert(o);

        Assertions.assertNotNull(result);

    }

    @Test
    void delete() {

        final Order orderTest = new Order();

        Order o = mock(Order.class);

        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(o);

        var service = new OrderService(repository, paymentRepository, productRepository);

        doThrow(new EmptyResultDataAccessException(1)).when(repository).deleteById(Mockito.anyLong());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.delete(1L));

    }

    @Test
    void deleteWithSecondThrow() {

        final Order orderTest = new Order();

        Order o = mock(Order.class);

        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(o);

        var service = new OrderService(repository, paymentRepository, productRepository);

        doThrow(new DataIntegrityViolationException("error")).when(repository).deleteById(anyLong());

        Assertions.assertThrows(DatabaseException.class, () -> service.delete(1L));

    }

    @Test
    void update() {

        Product product = mock(Product.class);

        Product p = new Product();
        p.setPrice(100.0);
        p.setId(1L);

        Order o = new Order();
        o.setPrice(100.0);
        o.setProduct(p);
        o.setQuantity(5);

        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(product);

        when(productRepository.findById(anyLong())).thenReturn(optional);

        var service = new OrderService(repository, paymentRepository, productRepository);

        when(repository.save(any())).thenReturn(o);
        var result = service.insert(o);

        Assertions.assertNotNull(result);
    }


    @Test
    void updateWithThrow() {
        Product p = new Product();
        p.setPrice(100.0);
        p.setId(1L);

        Order o = new Order();
        o.setPrice(100.0);
        o.setProduct(p);
        o.setQuantity(5);

        Optional optional = mock(Optional.class);

        when(productRepository.findById(Mockito.anyLong())).thenReturn(optional);

        when(optional.get()).thenThrow(new EntityNotFoundException("error"));

        when(repository.save(any())).thenReturn(o);

        var service = new OrderService(repository, paymentRepository, productRepository);

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> service.update(1L, o));
    }
}
