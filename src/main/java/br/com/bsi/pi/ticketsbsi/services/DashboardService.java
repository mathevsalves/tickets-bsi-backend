package br.com.bsi.pi.ticketsbsi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardAddressDTO;
import br.com.bsi.pi.ticketsbsi.entities.dto.DashboardDTO;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;

@Service
public class DashboardService {

    @Autowired
    private OrderRepository orderRepository;

    public DashboardService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<DashboardDTO> findDashboard() {
        var list = this.orderRepository.findDashboard();
        return list;
    }

    public List<DashboardAddressDTO> findDashboardAddress() {
        var list = this.orderRepository.findDashboardAddress();
        return list;
    }

    
}
