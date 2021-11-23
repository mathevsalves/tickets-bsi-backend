package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.repository = orderRepository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional <Order> obj = repository.findById(id);
        return obj.get();
    }

    public Order insert(Order order) {
        return repository.save(order);
    }

}
