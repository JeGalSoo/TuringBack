package com.turing.api.player.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String playerId;
    String playerName;
    String ePlayerName;
    @Column(name = "join_yyyy")
    String joinYyyy;
    String position;
    Long backNo;
    String nation;
    Date birthDate;
    String solar;
    Long height;
    Long weiget;
    String teamId;





}
