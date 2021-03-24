package com.example.security.dao;

import com.example.security.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ClientDAO extends JpaRepository<Client, Integer> {
    Client findByLogin(String login);
}
