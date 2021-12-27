package com.tot.backend.service;

import com.tot.backend.dto.UserDto;
import com.tot.backend.model.User;
import com.tot.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> createUser(UserDto userDto) {
        User user = new User(userDto.getFirstName(), userDto.getLastName(),
                userDto.getEmail(), userDto.getPassword(),
                userDto.getPhone_number(), userDto.getDescription());
        try {
            User u = userRepository.save(user);
            u.setPassword(null);
            return new ResponseEntity<>(u, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("User Exist", HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Object> login(String username, String password) {
        User user = userRepository.login(username, password);
        user.setPassword(null);
        if (user.getEmail() != null || !user.getEmail().equals(""))
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>("User Not Found", HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<Object> changePassword(Long id, String currentPassword, String newPassword) {
        try {
            int b = userRepository.changePassword(id, currentPassword, newPassword);
            if (b == 1)
                return new ResponseEntity<>("password updated", HttpStatus.OK);
            else
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_FOUND);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_FOUND);
        }
    }
}
