package com.example.security.controllers;


import com.example.security.dao.UserDAO;
import com.example.security.models.User;
import lombok.AllArgsConstructor;
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


    @GetMapping("/")
    public String home(Principal principal) {
//        System.out.println(principal);
//        System.out.println(SecurityContextHolder.getContext().getAuthentication());
//        SecurityContextHolder
//                .getContext()
//                .setAuthentication(
//                        new UsernamePasswordAuthenticationToken("asd", "asd")
//                );


        return "home";
    }


    @GetMapping("/admin/test")
    public List<String> adminTest() {
        return Arrays.asList("kokos", "abrikos");
    }

    @GetMapping("/user/test")
    public List<String> userTest() {
        return Arrays.asList("milk", "shake");
    }

    @GetMapping("/wide")
    public String wide() {
        return "wide url";
    }


    @PostMapping("/register")
    public void register(@RequestBody User user) {
        System.out.println(user);
        String encode = passwordEncoder.encode(user.getPass());
        user.setPass(encode);
        System.out.println(user);
        userDAO.save(user);
    }
}
