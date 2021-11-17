package br.com.bsi.pi.ticketsbsi.services;

import br.com.bsi.pi.ticketsbsi.dto.LoginDTO;
import br.com.bsi.pi.ticketsbsi.entities.User;
import br.com.bsi.pi.ticketsbsi.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserRepository repository = Mockito.mock(UserRepository.class);

    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = new UserService(repository);
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

        User u = Mockito.mock(User.class);

        Mockito.when(repository.findById(l)).thenReturn(java.util.Optional.ofNullable(u));

        var result = repository.findById(l);

        Assertions.assertNotNull(result);
    }

    @Test
    void insert() {

        final User userTest = new User();

        User u = Mockito.mock(User.class);

        Mockito.when(repository.save(userTest)).thenReturn(u);

        var result = repository.save(userTest);

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

        User u = Mockito.mock(User.class);

        Mockito.when(repository.save(userTest)).thenReturn(u);

        var result = repository.save(userTest);

        Assertions.assertNotNull(result);
    }

    @Test
    void login() {
//        final LoginDTO login = new LoginDTO();
//
//        User u = Mockito.mock(User.class);
//
//        Mockito.when(repository.login(login)).thenReturn(u);
//
//        var result = repository.login(login);
//
//        Assertions.assertNotNull(result);
    }
}
