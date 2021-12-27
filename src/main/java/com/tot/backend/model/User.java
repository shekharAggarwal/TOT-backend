package com.tot.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET latin1 COLLATE latin1_general_cs not NULL")
    private String password;

    @Column(unique = true, nullable = false)
    private String phone_number;

    private String description;
    private LocalDateTime email_verified_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String remember_token;

    public User(String firstName, String lastName, String email, String password, String phone_number, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.description = description;
    }

    public User() {
    }
}
