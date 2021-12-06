package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductResourceTest {

    private final ProductService service = Mockito.mock(ProductService.class);

    private ProductResource resource;

    @BeforeEach
    public void setup() {
        resource = new ProductResource(service);
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
        Product product = Mockito.mock(Product.class);

        Mockito.when(service.findById(id)).thenReturn(product);

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
        final Product productTest = new Product();
        Product product = mock(Product.class);
        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(product);

        when(service.update(id, productTest)).thenReturn(product);

        var result = resource.update(1L, productTest);

        Assertions.assertNotNull(result);
    }

}
