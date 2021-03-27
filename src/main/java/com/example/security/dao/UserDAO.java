package com.example.security.dao;

import com.example.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);
}
