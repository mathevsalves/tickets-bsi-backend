package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.Category;
import br.com.bsi.pi.ticketsbsi.services.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryResourceTest {

    CategoryService service = mock(CategoryService.class);

    CategoryResource resource;

    @BeforeEach
    public void setup() {
        resource = new CategoryResource(service);
    }

    @Test
    void findAll() {

        when(service.findAll()).thenReturn(new ArrayList<>());

        var result = resource.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {

        Long id = 1L;

        Category c = mock(Category.class);

        when(service.findById(id)).thenReturn(c);

        var result = resource.findById(id);

        Assertions.assertNotNull(result);
    }
}
