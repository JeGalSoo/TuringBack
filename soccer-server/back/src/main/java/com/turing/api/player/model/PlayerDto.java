package com.turing.api.player.model;


import com.querydsl.core.annotations.QueryProjection;
import com.turing.api.team.model.Team;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@NoArgsConstructor
@Builder
@Data
@Log4j2
public class PlayerDto {

    private Long id;
    private String playerId;
    private String playerName;
    private String ePlayerName;
    private String joinYyyy;
    private String position;
    private String backNo;
    private String nickname;
    private String nation;
    private String birthDate;
    private String solar;
    private String height;
    private String weight;

    private String teamId;
    @QueryProjection
    public PlayerDto(String playerName, String position, String teamId) {
        this.playerName = playerName;
        this.position = position;
        this.teamId = teamId;
    }

    @QueryProjection
    public PlayerDto(Long id, String playerId, String playerName, String ePlayerName, String joinYyyy,
                     String position, String backNo, String nickname, String nation, String birthDate,
                     String solar, String height, String weight, String teamId) {
        this.id = id;
        this.playerId = playerId;
        this.playerName = playerName;
        this.ePlayerName = ePlayerName;
        this.joinYyyy = joinYyyy;
        this.position = position;
        this.backNo = backNo;
        this.nickname = nickname;
        this.nation = nation;
        this.birthDate = birthDate;
        this.solar = solar;
        this.height = height;
        this.weight = weight;
        this.teamId = teamId;
    }

    @QueryProjection
    public PlayerDto(String playerName, String position) {
        this.playerName = playerName;
        this.position = position;
    }

    @QueryProjection
    public PlayerDto(String position) {
        this.position = position;
    }

}
