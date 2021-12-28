package com.tot.backend.service;

import com.tot.backend.config.JwtUtils;
import com.tot.backend.model.ERole;
import com.tot.backend.model.Role;
import com.tot.backend.model.User;
import com.tot.backend.payload.request.ChangePasswordDto;
import com.tot.backend.payload.request.LoginDto;
import com.tot.backend.payload.request.UserDto;
import com.tot.backend.payload.response.LoginResponse;
import com.tot.backend.payload.response.MessageResponse;
import com.tot.backend.repository.RoleRepository;
import com.tot.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public ResponseEntity<Object> createUser(UserDto userDto) {

        if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Phone Number is already in use!"));
        }

        if (userRepository.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        String password = bcryptEncoder.encode(userDto.getPassword());
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), password, userDto.getPhoneNumber(), userDto.getDescription());
        try {
            //getting role from database
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            //setting user role in role table by user id
            user.setRoles(roles);
            //saving user to database
            userRepository.save(user);

            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(new MessageResponse("Error: Try Again."), HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Object> login(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),
                            loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
            return new ResponseEntity<>(new LoginResponse(userDetails.getId(), userDetails.getPhoneNumber(), userDetails.getEmail(), userDetails.getDescription(), jwt, "Bearer", roles), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new MessageResponse("User Not Found"), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Object> changePassword(ChangePasswordDto changePasswordDto) {
        try {
            String nPwd = bcryptEncoder.encode(changePasswordDto.getNewPassword());
            //getting username by token
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            //checking current password is correct or not
            if (bcryptEncoder.matches(changePasswordDto.getCurrentPassword(), userDetails.getPassword())) {
                int b = userRepository.changePassword(userDetails.getUsername(), nPwd);
                if (b == 1) {
                    return login(new LoginDto(userDetails.getUsername(), changePasswordDto.getNewPassword()));
                } else return new ResponseEntity<>(new MessageResponse("Something went wrong!"), HttpStatus.NOT_FOUND);
            } else return new ResponseEntity<>(new MessageResponse("Current Wrong Password"), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse("Some Thing went wrong! "), HttpStatus.NOT_FOUND);
        }
    }
}
