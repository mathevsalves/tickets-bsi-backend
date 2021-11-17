package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Category;
import br.com.bsi.pi.ticketsbsi.repositories.CategoryRepository;
import br.com.bsi.pi.ticketsbsi.resources.CategoryResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class CategoryServiceTest {

    private CategoryRepository repository = Mockito.mock(CategoryRepository.class);

    private CategoryService categoryService;

    @BeforeEach
    public void setup() {
        categoryService = new CategoryService(repository);
    }

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        var result = repository.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {
        final Long l = 1L;

        Category c = Mockito.mock(Category.class);

        Mockito.when(repository.findById(l)).thenReturn(java.util.Optional.ofNullable(c));

        var result = repository.findById(l);

        Assertions.assertNotNull(result);
    }
}
