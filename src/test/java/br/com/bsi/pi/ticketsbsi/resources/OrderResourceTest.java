package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.services.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderResourceTest {

    private final OrderService service = Mockito.mock(OrderService.class);

    private OrderResource resource;

    @BeforeEach
    public void setup() {
        resource = new OrderResource(service);
    }

    @Test
    void findAll() {

        Mockito.when(service.findAll()).thenReturn(new ArrayList<>());

        var result = resource.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {
        final Long id = 1L;
        Order order = Mockito.mock(Order.class);

        Mockito.when(service.findById(id)).thenReturn(order);

        var result = resource.findById(id);

        Assertions.assertNotNull(result);

    }

    @Test
    void insert() {
//        final Product productTest = new Product();
//        Product product = mock(Product.class);
//
//        when(service.insert(productTest)).thenReturn(product);
//
//        var result = resource.insert(productTest);
//
//        Assertions.assertNotNull(result);
    }

    @Test
    void delete() {
        Long id = 1L;
        var result = resource.delete(id);

        Assertions.assertNotNull(result);
    }

    @Test
    void update() {
        final Long id = 1L;
        final Order orderTest = new Order();
        Order order = mock(Order.class);
        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(order);

        when(service.update(id, orderTest)).thenReturn(order);

        var result = resource.update(1L, orderTest);

        Assertions.assertNotNull(result);
    }
}
