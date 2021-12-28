package com.tot.backend.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ChangePasswordDto {
    @NotBlank
    private String currentPassword;
    @NotBlank
    private String newPassword;
}
