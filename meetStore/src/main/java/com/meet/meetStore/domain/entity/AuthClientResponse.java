package com.meet.meetStore.domain.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthClientResponse {
    private Client client;
    private String accessToken;
}
