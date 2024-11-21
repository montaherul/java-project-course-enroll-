package com.yourcompany.courseenrollment.service;

import com.yourcompany.courseenrollment.model.User;

import main.java.com.yourcompany.courseenrollment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yourcompany.courseenrollment.service.UserService;

@Configuration
class AppConfig {

    @Bean
    public UserService userService() {
        return new UserService();
    }
}

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
