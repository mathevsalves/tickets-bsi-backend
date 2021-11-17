package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.entities.Category;
import br.com.bsi.pi.ticketsbsi.services.CategoryService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryResourceTest {

    private CategoryService service = Mockito.mock(CategoryService.class);

    private CategoryResource categoryResource;

    @BeforeEach
    public void setup() {
        categoryResource = new CategoryResource(service);
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

        Category c = Mockito.mock(Category.class);

        Mockito.when(service.findById(l)).thenReturn(c);

        var result = service.findById(l);

        Assertions.assertNotNull(result);
    }
}
