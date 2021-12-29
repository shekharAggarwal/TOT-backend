package com.tot.backend.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PropertyDto {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String summary;
    @NotBlank
    private float lat;
    @NotBlank
    private float lang;
    @NotBlank
    private int type;//[1->HOTEL,2->BUNKBED,3->VILA]
}