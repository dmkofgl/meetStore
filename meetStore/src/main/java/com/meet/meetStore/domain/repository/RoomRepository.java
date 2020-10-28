package com.meet.meetStore.domain.repository;

import com.meet.meetStore.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
