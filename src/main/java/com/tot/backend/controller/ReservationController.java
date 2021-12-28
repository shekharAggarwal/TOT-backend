package com.tot.backend.controller;

import com.tot.backend.model.Reservation;
import com.tot.backend.payload.request.ReservationDto;
import com.tot.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/reservation")
@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/addReservation")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OWNER') or hasRole('USER')")
    public Reservation addReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.addReservation(reservationDto);
    }

}
