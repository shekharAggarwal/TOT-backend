package com.tot.backend.service;

import com.tot.backend.dto.RoomDto;
import com.tot.backend.model.Room;
import com.tot.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(RoomDto roomDto) {
        Room room = new Room();
        return roomRepository.save(room);
    }
}
