package ru.netology.cloud.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.cloud.models.Login;
import ru.netology.cloud.models.LoginPostRequest;
import ru.netology.cloud.security.jwt.WebSecurityConfig;

@CrossOrigin(origins = "http://192.168.99.100:8081")
@RestController
public class LoginApiImpl implements LoginApi{
///
    private final WebSecurityConfig service;

    public LoginApiImpl(WebSecurityConfig service) {
        this.service = service;
    }
///
    @Override
    @PostMapping("/login")
    public ResponseEntity<Login> loginPost(@RequestBody LoginPostRequest loginPostRequest) {
      //  return LoginApi.super.loginPost(loginPostRequest);
        // Чтобы я не пытался писать здесь - это не работает
        return new ResponseEntity("Hello from Login!", HttpStatus.OK);

    }
}
