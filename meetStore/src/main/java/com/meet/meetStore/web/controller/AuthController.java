package com.meet.meetStore.web.controller;

import com.meet.meetStore.domain.entity.Client;
import com.meet.meetStore.domain.repository.ClientRepository;
import com.meet.meetStore.domain.response.AuthClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth/")
public class AuthController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("signup")
    public ResponseEntity<AuthClientResponse> signup(@RequestBody Client client) {
        Client savedClient = clientRepository.save(client);
        if (savedClient == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedClient.getId())
                    .toUri();

            AuthClientResponse clientResponse = AuthClientResponse.builder().client(savedClient).accessToken("1111").build();
            return ResponseEntity.created(uri)
                    .body(clientResponse);
        }
    }

    @PostMapping("login")
    public ResponseEntity<AuthClientResponse> login(@RequestBody Client client) {
        Client savedClient = clientRepository.findByLoginAndPhone(client.getLogin(),client.getPhone()).orElse(null);
        if (savedClient == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedClient.getId())
                    .toUri();
            AuthClientResponse clientResponse = AuthClientResponse.builder().client(savedClient).accessToken("1111").build();
            return ResponseEntity.created(uri)
                    .body(clientResponse);
        }
    }
}
