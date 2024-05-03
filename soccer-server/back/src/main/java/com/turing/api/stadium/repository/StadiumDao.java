package com.turing.api.stadium.repository;

import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import com.turing.api.stadium.model.Stadium;
import com.turing.api.stadium.model.StadiumDto;

import java.util.List;

public interface StadiumDao {
    List<StadiumDto> getAllPlayers();

    Stadium p(Long id);

    void insert(Stadium player);
    void update(Stadium player);
}
