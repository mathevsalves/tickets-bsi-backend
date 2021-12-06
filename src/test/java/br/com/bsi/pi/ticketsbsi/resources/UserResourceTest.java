package br.com.bsi.pi.ticketsbsi.resources;

import br.com.bsi.pi.ticketsbsi.dto.LoginDTO;
import br.com.bsi.pi.ticketsbsi.entities.User;
import br.com.bsi.pi.ticketsbsi.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserResourceTest {

    private final UserService service = mock(UserService.class);

    private UserResource resource;

    @BeforeEach
    public void setup() {
        resource = new UserResource(service);
    }

    @Test
    void findAll() {
        when(service.findAll()).thenReturn(new ArrayList<>());

        var result = resource.findAll();

        Assertions.assertNotNull(result);

    }

    @Test
    void findById() {
        final Long id = 1L;
        User user = mock(User.class);

        when(service.findById(id)).thenReturn(user);

        var result = resource.findById(id);

        Assertions.assertNotNull(result);

    }

    @Test
    void insert() {
//        final User userTest = new User();
//        User user = mock(User.class);
//
//        when(service.insert(userTest)).thenReturn(user);
//
//        var result = resource.insert(userTest);
//
//        Assertions.assertNotNull(result);
    }

    @Test
    void delete() {
        Long id = 1L;
        service.delete(id);
    }

    @Test
    void update() {
        final Long id = 1L;

        User user = mock(User.class);

        when(service.update(id, user)).thenReturn(user);

        var result = resource.update(id, user);

        Assertions.assertNotNull(result);
    }

    @Test
    void login() {
        final LoginDTO login = new LoginDTO();

        User user = mock(User.class);

        when(service.login(login)).thenReturn(user);

        var result = resource.login(login);

        Assertions.assertNotNull(result);
    }
}
