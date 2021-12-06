package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.entities.Category;
import br.com.bsi.pi.ticketsbsi.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoryServiceTest {

    CategoryRepository repository = mock(CategoryRepository.class);

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        var service = new CategoryService(repository);

        var result = service.findAll();

        Assertions.assertNotNull(result);
    }

    @Test
    void findById() {
        Long id = 1L;
        Optional optional = mock(Optional.class);

        when(repository.findById(id)).thenReturn(optional);

        when(optional.get()).thenReturn(new Category());

        var service = new CategoryService(repository);

        var result = service.findById(id);

        Assertions.assertNotNull(result);
    }
}
