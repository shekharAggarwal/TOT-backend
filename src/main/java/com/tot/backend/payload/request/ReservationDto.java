package com.tot.backend.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String description;
//    private LocalDateTime email_verified_at;
}
