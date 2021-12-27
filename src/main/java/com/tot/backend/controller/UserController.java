package com.tot.backend.controller;

import com.tot.backend.dto.UserDto;
import com.tot.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@Validated @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);

    }

    @PostMapping("/changePassword")
    public ResponseEntity<Object> changePassword(@RequestParam Long id, @RequestParam String currentPassword, @RequestParam String newPassword) {
        return userService.changePassword(id, currentPassword, newPassword);
    }

}