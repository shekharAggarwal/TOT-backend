package com.tot.backend.controller;

import com.tot.backend.dto.UserDto;
import com.tot.backend.model.User;
import com.tot.backend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    userService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/user")
    public String user() {
        return "ss";
    }

}