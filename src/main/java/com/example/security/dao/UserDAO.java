package com.example.security.dao;

import com.example.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@NamedNativeQuery(name = "allUsers", query = "select * from user")
public interface UserDAO extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

//    @Query("select u from User u where u.username=:name")
//    User adsqwe(@Param("name") String xxx);
//
//    @Query("select x.username from User x join fetch x.authTokens")
//    List<String> asdqweasd(@Param("password") String password);
//
//    @Query(nativeQuery = true, name = "select * form user")
//    List<User> allUsers();
}
