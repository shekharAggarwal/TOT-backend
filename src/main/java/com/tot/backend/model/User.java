package com.tot.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user")
    @TableGenerator(name = "user", table = "hibernate_sequences", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET latin1 COLLATE latin1_general_cs not NULL")
    private String password;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    private String description;
    private LocalDateTime email_verified_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public User(String firstName, String lastName, String email, String password, String phoneNumber, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public User() {
    }
}
