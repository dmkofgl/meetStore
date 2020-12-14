package com.meet.meetStore.domain.response;

import com.meet.meetStore.domain.entity.Client;
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
