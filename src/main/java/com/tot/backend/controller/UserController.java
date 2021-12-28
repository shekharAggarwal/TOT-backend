package com.tot.backend.controller;

import com.tot.backend.payload.request.ChangePasswordDto;
import com.tot.backend.payload.request.LoginDto;
import com.tot.backend.payload.request.UserDto;
import com.tot.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }
}