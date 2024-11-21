package com.yourcompany.courseenrollment.controller;

import com.yourcompany.courseenrollment.model.Role;
import com.yourcompany.courseenrollment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.yourcompany.courseenrollment.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.yourcompany.courseenrollment.service.UserService;





@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Registration Page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values());
        return "register";
    }

    // Handle Registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if(userService.findByEmail(user.getEmail()) != null){
            model.addAttribute("error", "User already exists with this email.");
            return "register";
        }
        userService.registerUser(user);
        return "redirect:/login";
    }

    // Login Page is handled by Spring Security
}
