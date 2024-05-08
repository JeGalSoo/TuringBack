package com.turing.api.player.repository;

import com.turing.api.player.model.PlayerDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface PlayerDao {
    List<PlayerDto> getAllPlayers();

    List<String> getNo2Dsl();
    List<PlayerDto> getNo3Dsl();
    List<PlayerDto> getNo4Dsl();
    List<PlayerDto> getNo5Dsl();
    List<PlayerDto> getNo5HM1Dsl();

    List<PlayerDto> getNo6Dsl();
    List<PlayerDto> getNo7Dsl();
    List<Map<String, String>> getNo8Dsl();
    List<PlayerDto> getNo9Dsl();
    List<PlayerDto> getNo18Dsl();
    List<PlayerDto> getNo22Dsl();

    Long countAllPlayers();



}
