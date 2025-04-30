package com.educandoweb.course.configs;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "(12) 3456-7890", "maria@123!");
        User u2 = new User(null, "Alex Green", "alex@hotmail.com", "(09) 8765-4321", "AleXg012!?");

        Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), OrderStatus.PAID ,u2);
        Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT ,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
