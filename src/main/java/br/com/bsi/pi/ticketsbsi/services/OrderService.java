package br.com.bsi.pi.ticketsbsi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;
import br.com.bsi.pi.ticketsbsi.services.exceptions.DatabaseException;
import br.com.bsi.pi.ticketsbsi.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order order) {
        Double sum = 0.0;
        sum += order.getQuantity() * order.getProduct().getPrice();
        order.setTotal(sum);
        order = repository.save(order);
        return order;
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Order update(Long id, Order order) {
        try {
            Double sum = 0.0;
            sum += order.getQuantity() * order.getProduct().getPrice();
            order.setTotal(sum);
            order = repository.save(order);
            return order;
        } catch (

        EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
