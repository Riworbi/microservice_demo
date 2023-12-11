package com.demo.microservice.demo_microservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api")
public class simpleController {

    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @PostMapping(value = "/register")
    public HttpStatus postMethodName(@RequestBody RegisterForm entity) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails newUser = User
                .withUsername(entity.getUsername())
                .password(encoder.encode(entity.getPassword()))
                .authorities("USER").build();
        jdbcUserDetailsManager.createUser(newUser);

        return HttpStatus.CREATED;
    }

}
