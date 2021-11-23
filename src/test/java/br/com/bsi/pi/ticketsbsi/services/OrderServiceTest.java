package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderServiceTest {

    OrderRepository orderRepository = Mockito.mock(OrderRepository.class);

    @Test
    void findAll() {
        Mockito.when(orderRepository.findAll()).thenReturn(new ArrayList<>());

        var service = new OrderService(orderRepository);

        var result = service.findAll();

        Assertions.assertNotNull(result);
    }

    @Test
    void findById() {

        Long id = 1L;

        Optional optional = Mockito.mock(Optional.class);

        Mockito.when(orderRepository.findById(id)).thenReturn(optional);

        Mockito.when(optional.get()).thenReturn(new Order());

        var service = new OrderService(orderRepository);

        var result = service.findById(id);

        Assertions.assertNotNull(result);
    }

    @Test
    void insert() {

        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(new Order());

        var service = new OrderService(orderRepository);

        var result = service.insert(new Order());

        Assertions.assertNotNull(result);

    }

}
