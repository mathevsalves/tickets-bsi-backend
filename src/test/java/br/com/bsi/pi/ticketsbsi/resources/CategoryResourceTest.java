package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.Category;
import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.services.CategoryService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryResourceTest {

    CategoryService service = Mockito.mock(CategoryService.class);

    @Test
    void findAll() {

        Mockito.when(service.findAll()).thenReturn(new ArrayList<>());

        var resource = new CategoryResource(service);

        var result = service.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {

        Long id = 1L;

        Category c = Mockito.mock(Category.class);

        Mockito.when(service.findById(id)).thenReturn(c);

        var resource = new CategoryResource(service);

        var result = service.findById(id);

        Assertions.assertNotNull(result);
    }
}
