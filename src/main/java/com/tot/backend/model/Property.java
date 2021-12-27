package com.tot.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "property")
@Getter
@Setter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "property")
    @TableGenerator(name = "property", table = "hibernate_sequences", allocationSize = 1)
    @Column(nullable = false)
    private Long pid;

    private Long owner_id;
    private String name;
    private String address;
    private String summary;
    private float latitude;
    private float longitude;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime published_at;
    private int type;
    private int status;

}
