package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductResourceTest {
    
    private ProductService service = Mockito.mock(ProductService.class);

    private ProductResource ProductResource;

    @BeforeEach
    public void setup() {
        ProductResource = new ProductResource(service);
    }

    @Test
    void findAll() {

        Mockito.when(service.findAll()).thenReturn(new ArrayList<>());

        var result = service.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {

        final Long l = 1L;

        Product p = Mockito.mock(Product.class);

        Mockito.when(service.findById(l)).thenReturn(p);

        var result = service.findById(l);

        Assertions.assertNotNull(result);

    }
}
