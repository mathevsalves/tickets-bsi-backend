package br.com.bsi.pi.ticketsbsi.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.bsi.pi.ticketsbsi.entities.Order;
import br.com.bsi.pi.ticketsbsi.entities.Payment;
import br.com.bsi.pi.ticketsbsi.entities.Product;
import br.com.bsi.pi.ticketsbsi.entities.User;
import br.com.bsi.pi.ticketsbsi.repositories.OrderRepository;
import br.com.bsi.pi.ticketsbsi.repositories.PaymentRepository;
import br.com.bsi.pi.ticketsbsi.repositories.ProductRepository;
import br.com.bsi.pi.ticketsbsi.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private PaymentRepository paymentRepository;

        @Override
        public void run(String... args) throws Exception {

                User u1 = new User(null, "Matheus", "victor@gmail.com", "123456");
                User u2 = new User(null, "Victor", "matheus@gmail.com", "123456");
                User u3 = new User(null, "Administrador", "admin@admin.com", "123456");

                userRepository.saveAll(Arrays.asList(u1, u2, u3));

                Product p1 = new Product(null, null, "Zé Vaqueiro", "Caruaru - PE",
                                new Date(new Date().getTime() + 200000000L), 300.0,
                                "Cantor Zé Vaqueiro");
                Product p2 = new Product(null, null, "Thiaguinho", "São Paulo - SP", new Date(), 220.0,
                                "Cantor Thiaguinho");
                Product p3 = new Product(null, null, "Projota", "Rio de Janeiro - RJ", new Date(), 175.0,
                                "Cantor Projota");

                p1 = productRepository.save(p1);
                p2 = productRepository.save(p2);
                p3 = productRepository.save(p3);

                Payment pay1 = new Payment(null, "Daniel Lima", "1234567890123456", "11/29", "123", "12345678912",
                                "daniel@gmail.com");
                Payment pay2 = new Payment(null, "Daniel Lima", "1234567890123456", "11/29", "123", "12345678912",
                                "daniel@gmail.com");
                Payment pay3 = new Payment(null, "Daniel Lima", "1234567890123456", "11/29", "123", "12345678912",
                                "daniel@gmail.com");

                pay1 = paymentRepository.save(pay1);
                pay2 = paymentRepository.save(pay2);
                pay3 = paymentRepository.save(pay3);

                Order o1 = new Order(null, 2, p1.getPrice(), p1, pay1, p1.getPrice() * 3);
                // Order o2 = new Order(null, pay2, c2, null);
                // Order o3 = new Order(null, pay3, c3, null);

                o1 = orderRepository.save(o1);
                // o2 = orderRepository.save(o2);
                // o3 = orderRepository.save(o3);

                System.out.println("Rodando TESTCONFIG");
        }
}
