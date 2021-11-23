package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Category;
import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.repositories.CategoryRepository;
import br.com.bsi.pi.ticketsbsi.resources.CategoryResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryServiceTest {

    CategoryRepository repository = Mockito.mock(CategoryRepository.class);

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        var service = new CategoryService(repository);

        var result = service.findAll();

        Assertions.assertNotNull(result);
    }

    @Test
    void findById() {

        Long id = 1L;

        Optional optional = Mockito.mock(Optional.class);

        Category c = Mockito.mock(Category.class);

        Mockito.when(repository.findById(id)).thenReturn(optional);

        Mockito.when(optional.get()).thenReturn(new Category());

        var service = new CategoryService(repository);

        var result = service.findById(id);

        Assertions.assertNotNull(result);
    }
}
