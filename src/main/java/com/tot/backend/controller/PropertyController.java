package com.tot.backend.controller;

import com.tot.backend.dto.PropertyDto;
import com.tot.backend.dto.RoomDto;
import com.tot.backend.model.Property;
import com.tot.backend.model.Room;
import com.tot.backend.service.PropertyService;
import com.tot.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private RoomService roomService;

    @PostMapping("/addProperty")
    public Property addProperty(@RequestBody PropertyDto propertyDto) {
        return propertyService.addProperty(propertyDto);
    }

    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody RoomDto roomDto) {
        return roomService.addRoom(roomDto);
    }

}
