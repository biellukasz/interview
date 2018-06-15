package com.example.interview.controller;

import com.example.interview.entity.dto.User;
import com.example.interview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @CrossOrigin("*")
    @RequestMapping("/user")
    public boolean user(@RequestBody User user){
        return userService.validateUser(user);

    }
}
