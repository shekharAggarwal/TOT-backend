package com.tot.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "room")
    @TableGenerator(name = "room", table = "hibernate_sequences", allocationSize = 1)
    @Column(nullable = false)
    private Long rid;

    private Long pid;
    private String room_type;
    private boolean has_tv;
    private boolean has_heating;
    private boolean has_ac;
    private boolean has_internet;
    private float price;
    private int total_rooms;
    private int available_rooms;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime published_at;
    private int status;
}
