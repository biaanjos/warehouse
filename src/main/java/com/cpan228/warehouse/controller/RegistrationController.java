package com.cpan228.warehouse.controller;
import com.cpan228.warehouse.data.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan228.warehouse.model.form.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showRegistrationForm() {
        return "authentication/register";
    }

    @PostMapping
    public String registerUserAccount(RegistrationForm form) {
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/";
    }
}
