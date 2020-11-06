package com.meet.meetStore.web.controller;

import com.meet.meetStore.domain.entity.Room;
import com.meet.meetStore.domain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getClientById(@PathVariable Long id) {
        return roomRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room room) {
        Room createdRoom = roomRepository.save(room);
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
