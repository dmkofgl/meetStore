package com.meet.meetStore.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "ROOM_DATE")
public class RoomDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnoreProperties(value = {"roomDates", "rooms"})
    private Client client;
    @ManyToOne
    @JsonIgnoreProperties("dates")
    private Room room;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date finishDate;
    private String titile;
}
