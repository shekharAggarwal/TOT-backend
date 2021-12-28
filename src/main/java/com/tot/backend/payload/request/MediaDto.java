package com.tot.backend.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String description;
//    private LocalDateTime email_verified_at;
}
