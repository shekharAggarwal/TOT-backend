package com.tot.backend.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RoomDto {
    @NotBlank
    private String roomType;
    @NotBlank
    private boolean hasTv;
    @NotBlank
    private boolean hasAc;
    @NotBlank
    private boolean hasHeating;
    @NotBlank
    private boolean hasAC;
    @NotBlank
    private float price;
    @NotBlank
    private int totalRoom;
}
