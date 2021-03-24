package com.example.security.controllers;

import com.example.security.dao.ClientDAO;
import com.example.security.models.Client;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class MainController {

    private PasswordEncoder passwordEncoder;
    private ClientDAO clientDAO;


    public MainController(PasswordEncoder passwordEncoder, ClientDAO clientDAO) {
        this.passwordEncoder = passwordEncoder;
        this.clientDAO = clientDAO;
    }

    @PostMapping("/signUp")
    public void singUp(@RequestBody Client client) {
        System.out.println(client);
        String pass = client.getPass();
        String encode = passwordEncoder.encode(pass);
        client.setPass(encode);
        clientDAO.save(client);
    }

    @GetMapping("/")
    public List<Client> home() {

        return clientDAO.findAll();
    }
}
