package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.Category;
import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.services.CategoryService;
import br.com.bsi.pi.ticketsbsi.services.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderResourceTest {

    private OrderService service = Mockito.mock(OrderService.class);

    private OrderResource orderResource;

    @BeforeEach
    public void setup() {
        orderResource = new OrderResource(service);
    }

    @Test
    void findAll() {

        Mockito.when(service.findAll()).thenReturn(new ArrayList<>());

        var result = orderResource.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {

        final Long l = 1L;

        Order o = Mockito.mock(Order.class);

        Mockito.when(service.findById(l)).thenReturn(o);

        var result = orderResource.findById(l);

        Assertions.assertNotNull(result);

    }

    @Test
    void insert() {

        final Order order = new Order();

        Order o = Mockito.mock(Order.class);

        Mockito.when(service.insert(order)).thenReturn(o);

        var result = orderResource.insert(order);

        Assertions.assertNotNull(result);

    }
}
