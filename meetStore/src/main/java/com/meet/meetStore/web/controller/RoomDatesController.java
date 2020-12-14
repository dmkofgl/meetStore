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
@RequestMapping("/rooms/{roomId}/dates")
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
    public ResponseEntity<List<RoomDate>> create(@RequestBody List<RoomDate> roomDates) {
        List<RoomDate> createdRoomDates = roomDatesRepository.saveAll(roomDates);
        if (createdRoomDates == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdRoomDates)
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdRoomDates);
        }
    }
}
