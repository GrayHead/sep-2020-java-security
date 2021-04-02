package com.example.security.controllers;


import com.example.security.dao.UserDAO;
import com.example.security.mailService.MailService;
import com.example.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;
    private MailService mailService;

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("success!!!!!");
    }


    @GetMapping("/email/{email}")
    public void sendEmail(@PathVariable String email) {
        System.out.println(email);
        mailService.send(email);
    }

    @GetMapping("/activate/{id}")
    public void activateUser(@PathVariable int id) {
        // do stuff user by id
        System.out.println("we activate user - " + id);
        User user = userDAO.findById(id).get();
        user.setEnabled(true);
        userDAO.save(user);

        userDAO.deleteAll();

    }

    @GetMapping("/")
    public void placeholder() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity httpEntity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> exchange = restTemplate.exchange("http://jsonplaceholder.typicode.com/users/",
                HttpMethod.GET,
                httpEntity,
                String.class);
        System.out.println(exchange.getBody().toString());

    }


}
