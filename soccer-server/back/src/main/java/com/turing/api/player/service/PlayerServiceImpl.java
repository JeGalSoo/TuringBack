package com.turing.api.player.service;


import com.turing.api.player.model.PlayerDto;
import com.turing.api.player.repository.PlayerRepository;
import com.turing.api.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;


    @Override
    public List<PlayerDto> findAllPosition() {
        return playerRepository.getAllPosition();
    }

    @Override
    public List<PlayerDto> findAllPositionincludeNull() {
//        return playerRepository.getAllPositionincludeNull();
        return null;
    }

    @Override
    public List<PlayerDto> findAllByPositionAndTeamID() {
        return null;
//        return playerRepository.getAllByPositionAndTeamID();
    }

    @Override
    public List<PlayerDto> findAllByPositionAndTeamName() {

//        return playerRepository.getAllByPositionAndTeamName();
        return null;
    }

    @Override
    public List<PlayerDto> findAllByPlayerNameAndHeightAndTeam() {
        return playerRepository.getAllByPlayerNameAndHeightAndTeam();
    }

    @Override
    public List<PlayerDto> findAllByPlayerNameAndHeight() {
        return playerRepository.getAllByPlayerNameAndHeight();
    }


}
