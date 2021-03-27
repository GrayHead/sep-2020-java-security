package com.example.security.controllers;


import com.example.security.dao.UserDAO;
import com.example.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("success!!!!!");
    }


}
