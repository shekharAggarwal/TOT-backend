package com.tot.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "media")
@Getter
@Setter
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "media")
    @TableGenerator(name = "media", table = "hibernate_sequences", allocationSize = 1)
    @Column(nullable = false)
    private Long mid;

    private String model_id;
    private String model_type;
    private String file_type;
    private String file_name;
}
