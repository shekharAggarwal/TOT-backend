package com.tot.backend.controller;

import com.tot.backend.model.Property;
import com.tot.backend.model.Room;
import com.tot.backend.payload.request.PropertyDto;
import com.tot.backend.payload.request.RoomDto;
import com.tot.backend.service.PropertyService;
import com.tot.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/property")
@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private RoomService roomService;

    @PostMapping("/addProperty")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OWNER')")
    public Property addProperty(@Valid @RequestBody PropertyDto propertyDto) {
        return propertyService.addProperty(propertyDto);
    }

    @PostMapping("/addRoom")
    @PreAuthorize("hasRole('ADMIN') or hasRole('OWNER')")
    public Room addRoom(@Valid @RequestBody RoomDto roomDto) {
        return roomService.addRoom(roomDto);
    }
}