package com.turing.api.player.service;

import com.turing.api.player.model.PlayerDto;

import java.util.List;

public interface PlayerService {
    List<PlayerDto> findAllPosition();

    List<PlayerDto> findAllPositionincludeNull();

    List<PlayerDto> findAllByPositionAndTeamID();

    List<PlayerDto> findAllByPositionAndTeamName();

    List<PlayerDto> findAllByPlayerNameAndHeightAndTeam();

    List<PlayerDto> findAllByPlayerNameAndHeight();
}
