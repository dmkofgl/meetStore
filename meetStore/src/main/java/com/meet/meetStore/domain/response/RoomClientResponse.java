package com.meet.meetStore.domain.response;

import com.meet.meetStore.domain.entity.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomClientResponse {
    private Long id;
    private String login;

    public static RoomClientResponse of(Client client){
        return RoomClientResponse.builder()
                .id(client.getId())
                .login(client.getLogin())
                .build();
    }

}
