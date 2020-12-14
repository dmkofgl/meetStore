package com.meet.meetStore.web.controller;

import com.meet.meetStore.domain.entity.Room;
import com.meet.meetStore.domain.repository.RoomRepository;
import com.meet.meetStore.domain.response.RoomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public ResponseEntity<Set<RoomResponse>> getRooms() {
        List<Room> rooms = roomRepository.findAll();
        Set<RoomResponse> roomResponses = rooms.stream().map(RoomResponse::of).peek(x -> x.setDates(null)).collect(Collectors.toSet());
        return ResponseEntity.ok()
                .body(roomResponses);

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
