package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class OrderServiceTest {


    private OrderRepository repository = Mockito.mock(OrderRepository.class);

    private OrderService orderService;

    @BeforeEach
    public void setup() {
        orderService = new OrderService(repository);
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

        Order o = Mockito.mock(Order.class);

        Mockito.when(repository.findById(l)).thenReturn(java.util.Optional.ofNullable(o));

        var result = repository.findById(l);

        Assertions.assertNotNull(result);
    }
}
