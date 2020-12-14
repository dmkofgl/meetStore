package com.meet.meetStore.domain.response;

import com.meet.meetStore.domain.entity.Room;
import com.meet.meetStore.domain.entity.RoomDate;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class RoomResponse {
    private Long id;
    private String name;
    private Set<RoomClientResponse> clients;
    private Set<RoomDatesResponse> dates;
    private boolean isPublic;
    private Date startDate;
    private Date lastDate;

    public static RoomResponse of(Room room) {
        Set<RoomClientResponse> clients = room.getClients().stream()
                .map(RoomClientResponse::of)
                .collect(Collectors.toSet());

        Set<RoomDatesResponse> datesResponses = room.getDates().stream()
                .map(RoomDatesResponse::of)
                .collect(Collectors.toSet());

        RoomResponse response = builder()
                .id(room.getId())
                .name(room.getName())
                .clients(clients)
                .dates(datesResponses)
                .build();
        return response;

    }

}


