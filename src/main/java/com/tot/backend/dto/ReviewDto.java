package com.tot.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String description;
//    private LocalDateTime email_verified_at;
}
