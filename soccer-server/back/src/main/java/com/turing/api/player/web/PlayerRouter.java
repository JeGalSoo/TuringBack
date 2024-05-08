package com.turing.api.player.web;


import com.turing.api.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PlayerRouter {

    private final PlayerRepository repository;

    @SuppressWarnings("unchecked")
    public List<?> execute(String q,String playerName,String position,String teamId ) {
        return switch (q) {
            case "position-list" -> repository.getNo2Dsl();
            case "3" -> repository.getNo3Dsl();
            case "4" -> repository.getNo4Dsl();
            case "5" -> repository.getNo5Dsl();
            case "5-1" -> repository.getNo5HM1Dsl();
            case "6" -> repository.getAllByPlayerNameAndHeightAndTeamName();
            case "7" -> repository.getAllByPositionAndRegion();
            case "8" -> repository.getPlayerNameAndHeigtAndWeightByRegion();
            case "9" -> repository.getPlayerNameAndHeigtAndWeightAndBMIByRegion();
            case "18" -> repository.getPlayer5Person();
            case "22" -> repository.getPlayerBestShortHeigt5Person();
            default -> null;
        };
    }
}