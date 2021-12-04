package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.Category;
import br.com.bsi.pi.ticketsbsi.services.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryResourceTest {

    CategoryService service = Mockito.mock(CategoryService.class);

    CategoryResource categoryResourceTest;

    @BeforeEach
    public void setup() {
        categoryResourceTest = new CategoryResource(service);
    }

    @Test
    void findAll() {

        Mockito.when(service.findAll()).thenReturn(new ArrayList<>());

        var result = categoryResourceTest.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {

        Long id = 1L;

        Category c = Mockito.mock(Category.class);

        Mockito.when(service.findById(id)).thenReturn(c);

        var result = categoryResourceTest.findById(id);

        Assertions.assertNotNull(result);
    }
}
