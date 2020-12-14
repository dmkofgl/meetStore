package com.meet.meetStore.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    @Column(unique = true)
    private String login;
    @ManyToMany
    @JsonIgnoreProperties("clients")
    private Set<Room> rooms;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @Singular
    private Set<RoomDate> roomDates;

}
