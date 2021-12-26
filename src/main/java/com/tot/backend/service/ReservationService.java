package com.tot.backend.service;

import com.tot.backend.dto.ReservationDto;
import com.tot.backend.model.Reservation;
import com.tot.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation addReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        return reservationRepository.save(reservation);
    }
}
