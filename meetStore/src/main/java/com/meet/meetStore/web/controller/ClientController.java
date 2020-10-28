package com.meet.meetStore.web.controller;

import com.meet.meetStore.domain.entity.Client;
import com.meet.meetStore.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client savedClient = clientRepository.save(client);
        if (savedClient == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedClient.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(savedClient);
        }
    }
}
