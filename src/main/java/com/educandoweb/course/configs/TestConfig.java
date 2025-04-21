package com.educandoweb.course.configs;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "(12) 3456-7890", "maria@123!");
        User u2 = new User(null, "Alex Green", "alex@hotmail.com", "(09) 8765-4321", "AleXg012!?");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
