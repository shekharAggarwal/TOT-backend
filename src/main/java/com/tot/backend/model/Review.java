package com.tot.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "review")
    @TableGenerator(name = "review", table = "hibernate_sequences", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

    private Long review_id;
    private float rating;
    private String comment;
}
