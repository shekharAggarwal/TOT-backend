package com.tot.backend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Long id;

    private String phoneNumber;

    private String email;

    private String description;

    private String token;

    private String type;

    private List<String> roles;
}
