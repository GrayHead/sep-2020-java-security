package com.example.security.dao;

import com.example.security.models.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenDAO extends JpaRepository<AuthToken, Integer> {

}
