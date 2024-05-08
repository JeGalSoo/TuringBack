package com.turing.api.team.repository;

import com.querydsl.core.Tuple;
import com.turing.api.team.model.Team;
import com.turing.api.team.model.TeamDto;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TeamDao {

    List<TeamDto> getAllTeamsDsl();

    List<?> getNo1Dsl();

    List<?> getNo10Dsl(String position1, String regionName1, String regionName2);

    List<?> getNo12Dsl(String regionName1, String regionName2);

    List<?> getNo13Dsl();

    List<?> getNo19Dsl(String regionName1);

    List<?> getNo20Dsl(String position1);

    List<?> getNo21Dsl();

    Long countAllTeams();

}
