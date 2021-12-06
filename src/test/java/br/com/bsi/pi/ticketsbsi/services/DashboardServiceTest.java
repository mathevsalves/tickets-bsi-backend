package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardAddressDTO;
import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardDTO;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DashboardServiceTest {

    OrderRepository orderRepository = mock(OrderRepository.class);

    @Test
    void findDashboard() {
        var list = new ArrayList<DashboardDTO>();

        when(orderRepository.findDashboard()).thenReturn(list);

        var service = new DashboardService(orderRepository);

        var result = service.findDashboard();

        Assertions.assertNotNull(result);
    }

    @Test
    void findDashboardAddress() {
        var list = new ArrayList<DashboardAddressDTO>();

        when(orderRepository.findDashboardAddress()).thenReturn(list);

        var service = new DashboardService(orderRepository);

        var result = service.findDashboardAddress();

        Assertions.assertNotNull(result);
    }
}
