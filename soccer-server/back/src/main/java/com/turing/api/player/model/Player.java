package com.turing.api.player.model;

import com.turing.api.team.model.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name="players")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="player_id")
    private String playerId;
    private String playerName;
    private String ePlayerName;
    private String nickname;
    @Column(name = "join_yyyy")
    private String joinYyyy;
    private String position;
    private Long backNo;
    private String nation;
    private Date birthDate;
    private String solar;
    private Long height;
    private Long weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Team teamId;



}
