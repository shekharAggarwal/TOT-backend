package com.tot.backend.service;

import com.tot.backend.dto.UserDto;
import com.tot.backend.model.User;
import com.tot.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getEmail(), userDto.getPassword());
        return userRepository.save(user);
    }
}
