package com.meet.meetStore.domain.repository;

import com.meet.meetStore.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Optional<Client> findByLoginAndPhone(String username, String phone);
}
