package com.bank.banking.controller;

import com.bank.banking.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        userService.register(username, password);
        return "User Registered";
    }
}