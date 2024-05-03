package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import com.turing.api.schedule.model.ScheduleDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerDAO {
    List<PlayerDto> getAllPlayers();

}
