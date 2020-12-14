package com.meet.meetStore.domain.response;

import com.meet.meetStore.domain.entity.RoomDate;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RoomDatesResponse {
    private Date start;
    private Date end;
    private String title;
    private Long clientId;

    public static RoomDatesResponse of(RoomDate date) {
        return RoomDatesResponse.builder()
                .start(date.getStartDate())
                .end(date.getFinishDate())
                .title(date.getTitile())
                .clientId(date.getClient().getId())
                .build();
    }
}
