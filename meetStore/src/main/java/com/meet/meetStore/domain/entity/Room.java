package com.meet.meetStore.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "rooms")
    private Set<Client> clients;
    @OneToMany(mappedBy = "room")
    private Set<RoomDate> dates;
    private boolean isPublic = true;

}
