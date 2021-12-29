package com.tot.backend.controller;

import com.tot.backend.payload.request.ChangePasswordDto;
import com.tot.backend.payload.request.LoginDto;
import com.tot.backend.payload.request.UserDto;
import com.tot.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/changePassword")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OWNER') or hasRole('USER')")
    public ResponseEntity<Object> changePassword(@Valid @RequestBody ChangePasswordDto changePasswordDto) {
        return userService.changePassword(changePasswordDto);
    }

//    @PostMapping("/toHost")
//    public ResponseEntity<Object> switchToHost(@Valid @RequestBody LoginDto loginDto) {
//        return userService.login(loginDto);
//    }

}