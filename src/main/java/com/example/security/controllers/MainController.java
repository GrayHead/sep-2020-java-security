package com.example.security.controllers;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

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
}
