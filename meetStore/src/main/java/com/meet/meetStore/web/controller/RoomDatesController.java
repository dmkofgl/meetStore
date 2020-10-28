package com.meet.meetStore.web.controller;

import com.meet.meetStore.domain.entity.Room;
import com.meet.meetStore.domain.entity.RoomDate;
import com.meet.meetStore.domain.repository.RoomDatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roomDates")
public class RoomDatesController {
    @Autowired
    private RoomDatesRepository roomDatesRepository;

    @GetMapping
    public List<RoomDate> getRooms() {
        return roomDatesRepository.findAll();
    }

    @GetMapping("/{id}")
    public RoomDate getClientById(@PathVariable Long id) {
        return roomDatesRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<RoomDate> create(@RequestBody RoomDate client) {
        RoomDate createdRoom = roomDatesRepository.save(client);
        if (createdRoom == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdRoom.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdRoom);
        }
    }
}
