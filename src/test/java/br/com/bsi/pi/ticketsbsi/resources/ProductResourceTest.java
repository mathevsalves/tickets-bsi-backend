package br.com.bsi.pi.ticketsbsi.resources;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.services.ProductService;

class ProductResourceTest {

    private ProductService service = Mockito.mock(ProductService.class);

    private ProductResource productResource;

    @BeforeEach
    public void setup() {
        productResource = new ProductResource(service);
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

        Product o = Mockito.mock(Product.class);

        Mockito.when(service.findById(l)).thenReturn(o);

        var result = service.findById(l);

        Assertions.assertNotNull(result);

    }

    }
