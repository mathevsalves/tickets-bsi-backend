package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.dto.LoginDTO;
import br.com.bsi.pi.ticketsbsi.entities.Order;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository repository = mock(UserRepository.class);

    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = new UserService(repository);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        var result = userService.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {
        final Long l = 1L;

        User u = mock(User.class);

        when(repository.findById(l)).thenReturn(java.util.Optional.ofNullable(u));

        var result = userService.findById(l);

        Assertions.assertNotNull(result);
    }

    @Test
    void insert() {

        final User userTest = new User();

        User u = mock(User.class);

        when(repository.save(userTest)).thenReturn(u);

        var result = userService.insert(userTest);

        Assertions.assertNotNull(result);

    }

    @Test
    void delete() {

//        final User userTest = new User();
//
//        User u = Mockito.mock(User.class);
//
//        Mockito.when(repository.delete(userTest)).thenReturn(u);
//
//        var result = repository.delete(userTest);
//
//        Assertions.assertNotNull(result);

    }

    @Test
    void update() {

        final User userTest = new User();

        User u = mock(User.class);

        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(u);

        when(repository.findById(Mockito.anyLong())).thenReturn(optional);

        when(repository.save(userTest)).thenReturn(u);

        var result = userService.update(1L, userTest);

        Assertions.assertNotNull(result);
    }


    @Test
    void updateWithThrow() {

        final User userTest = new User();

        User u = mock(User.class);

        Optional optional = mock(Optional.class);

        when(optional.get()).thenReturn(u);

        when(repository.findById(Mockito.anyLong())).thenThrow(new EntityNotFoundException("error"));

        when(repository.save(userTest)).thenReturn(u);

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> userService.update(1L, userTest));
    }

    @Test
    void login() {
        final LoginDTO login = new LoginDTO();
        login.setEmail("teste");
        login.setPassword("123");

        User u = Mockito.mock(User.class);
        u.setPassword("123");

        when(u.getPassword()).thenReturn("123");

        Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(u);

        var result = userService.login(login);

        Assertions.assertNotNull(result);
    }


    @Test
    void loginWithWrongUser() {
        final LoginDTO login = new LoginDTO();
        login.setEmail("teste");
        login.setPassword("1234");

        User u = Mockito.mock(User.class);
        u.setPassword("123");

        when(u.getPassword()).thenReturn("123");

        Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(u);

        var result = userService.login(login);

        Assertions.assertNull(result);
    }
}
