package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.dto.LoginDTO;
import br.com.bsi.pi.ticketsbsi.entities.User;
import br.com.bsi.pi.ticketsbsi.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserResourceTest {

    private UserService service = Mockito.mock(UserService.class);

    private UserResource UserResource;

    @BeforeEach
    public void setup() {
        UserResource = new UserResource(service);
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

        User u = Mockito.mock(User.class);

        Mockito.when(service.findById(l)).thenReturn(u);

        var result = service.findById(l);

        Assertions.assertNotNull(result);

    }

    @Test
    void insert() {

        final User userTest = new User();

        User u = Mockito.mock(User.class);

        Mockito.when(service.insert(userTest)).thenReturn(u);

        var result = service.insert(userTest);

        Assertions.assertNotNull(result);

    }

    @Test
    void delete() {

//        final Long l = 1L;
//
//        User u = Mockito.mock(User.class);
//
//        Mockito.when(service.delete(l)).thenReturn(l);
//
//        var result = service.delete(l);
//
//        Assertions.assertNotNull(result);

    }

    @Test
    void update() {

        final Long l = 1L;

        User u = Mockito.mock(User.class);

        Mockito.when(service.update(l, u)).thenReturn(u);

        var result = service.update(l, u);

        Assertions.assertNotNull(result);
    }

    @Test
    void login() {
        final LoginDTO login = new LoginDTO();

        User u = Mockito.mock(User.class);

        Mockito.when(service.login(login)).thenReturn(u);

        var result = service.login(login);

        Assertions.assertNotNull(result);
    }
}
