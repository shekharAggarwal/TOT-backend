package com.tot.backend.controller;

import com.tot.backend.dto.ReservationDto;
import com.tot.backend.model.Reservation;
import com.tot.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.addReservation(reservationDto);
    }

}
