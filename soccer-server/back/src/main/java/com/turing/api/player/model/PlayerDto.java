package com.turing.api.player.model;


import com.turing.api.team.model.Team;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;


@Builder
@Getter
public class PlayerDto {

    private Long id;
    private String playerId;
    private String playerName;
    private String ePlayerName;
    private String joinYyyy;
    private String position;
    private Integer backNo;
    private String nation;
    private Date birthDate;
    private String solar;
    private Integer height;
    private Integer weiget;


    private Long teamId;
}
