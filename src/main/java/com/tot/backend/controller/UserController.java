package com.tot.backend.controller;

import com.tot.backend.dto.UserDto;
import com.tot.backend.model.User;
import com.tot.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }



}