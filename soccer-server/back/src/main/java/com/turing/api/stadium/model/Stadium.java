package com.turing.api.stadium.model;

import com.turing.api.player.model.Player;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name="stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stadiumId;
    private String name;
    private Integer seatCount;
    private String address;
    private String ddd;
    private String tel;


}
