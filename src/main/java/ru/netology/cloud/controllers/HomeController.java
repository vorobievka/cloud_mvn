package ru.netology.cloud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home() {
        return "Hi, this is Cloud API!";  // <a href=\"http://localhost:8080/login\">Login</a>";
    }

}
