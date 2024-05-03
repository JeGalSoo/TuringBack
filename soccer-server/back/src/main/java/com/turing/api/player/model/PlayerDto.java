package com.turing.api.player.model;


import com.turing.api.team.model.Team;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@NoArgsConstructor
@AllArgsConstructor
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
    private String nation;
    private String birthDate;
    private String solar;
    private String height;
    private String weiget;

    private String teamId;
}
