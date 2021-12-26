package com.tot.backend.repository;

import com.tot.backend.model.Room;
import com.tot.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
