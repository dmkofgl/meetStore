package com.meet.meetStore.domain.repository;

import com.meet.meetStore.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
