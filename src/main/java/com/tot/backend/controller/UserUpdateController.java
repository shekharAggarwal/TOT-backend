package com.tot.backend.controller;

import com.tot.backend.payload.request.ChangePasswordDto;
import com.tot.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserUpdateController {

    @Autowired
    UserService userService;

    @PostMapping("/changePassword")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OWNER') or hasRole('USER')")
    public ResponseEntity<Object> changePassword(@Valid @RequestBody ChangePasswordDto changePasswordDto) {
        return userService.changePassword(changePasswordDto);
    }
}
