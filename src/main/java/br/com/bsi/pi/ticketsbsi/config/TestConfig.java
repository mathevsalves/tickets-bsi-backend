package br.com.bsi.pi.ticketsbsi.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.entities.User;
import br.com.bsi.pi.ticketsbsi.repositories.CategoryRepository;
import br.com.bsi.pi.ticketsbsi.repositories.OrderItemRepository;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;
import br.com.bsi.pi.ticketsbsi.repositories.ProductRepository;
import br.com.bsi.pi.ticketsbsi.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Matheus", "victor@gmail.com", "123456");
        User u2 = new User(null, "Victor", "matheus@gmail.com", "123456");
        User u3 = new User(null, "Administrador", "admin@admin.com", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));


        Product p1 = new Product(null, null, "Zé Vaqueiro", "Caruaru - PE", new Date(), 300.0,
                "Cantor Zé Vaqueiro");
        Product p2 = new Product(null, null, "Thiaguinho", "São Paulo - SP", new Date(), 220.0,
                "Cantor Thiaguinho");
        Product p3 = new Product(null, null, "Projota", "Rio de Janeiro - RJ", new Date(), 175.0,
                "Cantor Projota");

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        Order o1 = new Order(null, new Date(), 1L, "Jose Silva", "1234567890123456", "11/29", "123", "12345678998",
                "email@email.com");
        Order o2 = new Order(null, new Date(), 2L, "Maria Silva", "1234567890123456", "11/29", "123", "12345678998",
                "email@email.com");
        Order o3 = new Order(null, new Date(), 3L, "Matheus Silva", "1234567890123456", "11/29", "123", "12345678998",
                "email@email.com");

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
