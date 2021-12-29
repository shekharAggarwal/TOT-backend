package com.tot.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "property")
@Getter
@Setter
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "property")
    @TableGenerator(name = "property", table = "hibernate_sequences", allocationSize = 1)
    @Column(nullable = false)
    private Long pid;

    @NotBlank
    private Long owner_id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String summary;
    @NotBlank
    private float latitude;
    @NotBlank
    private float longitude;
    @NotBlank
    private int type;

    @JsonIgnore
    private LocalDateTime created_at;
    @JsonIgnore
    private LocalDateTime updated_at;
    @JsonIgnore
    private LocalDateTime published_at;
    private int status;

    public Property(Long owner_id, String name, String address, String summary, float latitude, float longitude, int type) {
        this.owner_id = owner_id;
        this.name = name;
        this.address = address;
        this.summary = summary;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.status = 0;
    }
}