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


    public List<?> execute(String q,String playerName,String position,String teamId ) {
        return switch (q) {
            case "2" -> repository.getAllPosition();
            case "3" -> repository.getAllPositionincludeNull();
            case "4" -> repository.getAllByPositionAndTeamId();
            case "5" -> repository.getAllByPlayerNameAndHeightAndTeamId();
            case "5-1" -> repository.getAllByPlayerNameAndHeightAndRegion();
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