package com.tot.backend.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "role")
    @TableGenerator(name = "role", table = "hibernate_sequences", allocationSize = 1)
    @Column(nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
}
