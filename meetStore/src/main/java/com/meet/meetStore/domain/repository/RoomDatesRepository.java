package com.meet.meetStore.domain.repository;

import com.meet.meetStore.domain.entity.Client;
import com.meet.meetStore.domain.entity.RoomDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoomDatesRepository extends JpaRepository<RoomDate, Long> {
}
