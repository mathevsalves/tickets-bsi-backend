package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardAddressDTO;
import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardDTO;
import br.com.bsi.pi.ticketsbsi.services.DashboardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DashboardResourceTest {

    DashboardService service = mock(DashboardService.class);

    private DashboardResource resource;

    @BeforeEach
    public void setup() {
        resource = new DashboardResource(service);
    }

    @Test
    void findDashboard() {
        var list = new ArrayList<DashboardDTO>();

        when(service.findDashboard()).thenReturn(list);

        var resource = new DashboardResource(service);

        var result = resource.findDashboard();

        Assertions.assertNotNull(result);
    }

    @Test
    void findDashboardAddress() {
        var list = new ArrayList<DashboardAddressDTO>();

        when(service.findDashboardAddress()).thenReturn(list);

        var resource = new DashboardResource(service);

        var result = resource.findDashboardAddress();

        Assertions.assertNotNull(result);
    }
}
