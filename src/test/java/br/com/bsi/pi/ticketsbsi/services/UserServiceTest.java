package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.dto.LoginDTO;
import br.com.bsi.pi.ticketsbsi.entities.User;
import br.com.bsi.pi.ticketsbsi.repositories.UserRepository;
import br.com.bsi.pi.ticketsbsi.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {

    private final UserRepository repository = mock(UserRepository.class);

    private UserService service;

    @BeforeEach
    public void setup() {
        service = new UserService(repository);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        var result = service.findAll();

        Assertions.assertNotNull(result);
    }

    @Test
    void findById() {
        final Long id = 1L;
        User user = mock(User.class);

        when(repository.findById(id)).thenReturn(java.util.Optional.ofNullable(user));

        var result = service.findById(id);

        Assertions.assertNotNull(result);
    }

    @Test
    void insert() {
        final User userTest = new User();
        User user = mock(User.class);

        when(repository.save(userTest)).thenReturn(user);

        var result = service.insert(userTest);

        Assertions.assertNotNull(result);
    }

    @Test
    void delete() {
        Long id = 1L;
        var service = new UserService(repository);

        service.delete(id);
    }

    @Test
    void update() {
        final User userTest = new User();
        User user = mock(User.class);
        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(user);

        when(repository.findById(Mockito.anyLong())).thenReturn(optional);

        when(repository.save(userTest)).thenReturn(user);

        var result = service.update(1L, userTest);

        Assertions.assertNotNull(result);
    }


    @Test
    void updateWithThrow() {
        final User userTest = new User();
        User user = mock(User.class);
        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(user);

        when(repository.findById(Mockito.anyLong())).thenThrow(new EntityNotFoundException("error"));

        when(repository.save(userTest)).thenReturn(user);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> service.update(1L, userTest));
    }

    @Test
    void login() {
        final LoginDTO login = new LoginDTO();
        login.setEmail("teste");
        login.setPassword("123");

        User u = Mockito.mock(User.class);
        u.setPassword("123");

        when(u.getPassword()).thenReturn("123");

        when(repository.findByEmail(Mockito.anyString())).thenReturn(u);

        var result = service.login(login);

        Assertions.assertNotNull(result);
    }


    @Test
    void loginWithWrongUser() {
        final LoginDTO login = new LoginDTO();
        login.setEmail("teste");
        login.setPassword("1234");

        User user = Mockito.mock(User.class);
        user.setPassword("123");

        when(user.getPassword()).thenReturn("123");

        when(repository.findByEmail(Mockito.anyString())).thenReturn(user);

        var result = service.login(login);

        Assertions.assertNull(result);
    }
}
