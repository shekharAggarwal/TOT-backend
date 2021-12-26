package com.tot.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long user_id;
    private Long room_id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime published_at;
    private int status;
    private float price;
    private float total;
}
