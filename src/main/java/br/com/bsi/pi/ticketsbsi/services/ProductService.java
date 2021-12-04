package br.com.bsi.pi.ticketsbsi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.repositories.ProductRepository;
import br.com.bsi.pi.ticketsbsi.services.exceptions.DatabaseException;
import br.com.bsi.pi.ticketsbsi.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> findAll(boolean isPrevious) {
        final Date dateNow = new Date();
        List<Product> list = new ArrayList<>();
        if (isPrevious) list = repository.findByDateShowLessThan(dateNow);
        else list = repository.findByDateShowGreaterThan(dateNow);
        return list;
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product insert(Product product) {
        return repository.save(product);
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

    public Product update(Long id, Product obj) {
        try {
            Product entity = repository.findById(id).get();
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setAddress(obj.getAddress());
        entity.setDateShow(obj.getDateShow());
        entity.setPrice(obj.getPrice());
        entity.setDescription(obj.getDescription());
    }

}
