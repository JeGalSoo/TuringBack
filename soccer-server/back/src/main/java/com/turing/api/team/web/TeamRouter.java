package com.turing.api.team.web;

import com.turing.api.team.model.Team;
import com.turing.api.team.repository.TeamRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class TeamRouter {

    private final TeamRepository repository;

    public List<Map<String, Team>> execute(String q, String position, String regionName1, String regionName2) {
        // List<Map<String, Team>> listmap = new ArrayList<>();
        // Map<String, Team> map = new HashMap<>();
        // Long key = Long.parseLong(q);

        // map.put(q,
        return switch (q) {
            case "1" -> repository.findAllTeams();
            // case "10" -> repository.findTeamByPosionAndRegionName(position, regionName1, regionName2);
            // case "12" -> repository.findTeamByPlayerHeightAndRegionName(regionName1, regionName2);
            // case "13"->repository.findAllTeamByPositionNull();
            // case "19"->repository.findTeamAngHeightByRegionName(regionName1);
            // case "20"->repository.findTeamByPosition(position);
            // case "21"->repository.find5PlayerByHeight();
            default -> null;
        }
        // )
        ;
        // for(int i=0;i<map.size();i++){
        // listmap.add(map);
        // }
        // return listmap;
        // 10 GK 수원 대전
    }
}
