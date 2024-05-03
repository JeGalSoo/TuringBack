package com.turing.api.team.repository;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.api.team.model.QTeam;
import com.turing.api.team.model.TeamDto;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TeamDaoImpl implements TeamDao {

    private final JPAQueryFactory factory;

    @Override
    public List<TeamDto> getAllTeams() {
        factory.select(
                QTeam.team.id,
                QTeam.team.teamId,
                QTeam.team.regionName,
                QTeam.team.teamName,
                QTeam.team.eTeamName,
                QTeam.team.origYyyy,
                QTeam.team.zipCode1,
                QTeam.team.zipCode2,
                QTeam.team.address,
                QTeam.team.ddd,
                QTeam.team.tel,
                QTeam.team.fax,
                QTeam.team.homepage,
                QTeam.team.owner,
                QTeam.team.stadiumId.id)
                .from(QTeam.team)
                .fetch()
                .stream()
                .map(tuple -> TeamDto.builder()
                        .id(tuple.get(QTeam.team.id))
                        .teamId(tuple.get(QTeam.team.teamId))
                        .regionName(tuple.get(QTeam.team.regionName))
                        .teamName(tuple.get(QTeam.team.teamName))
                        .eTeamName(tuple.get(QTeam.team.eTeamName))
                        .origYyyy(tuple.get(QTeam.team.origYyyy))
                        .zipCode1(tuple.get(QTeam.team.zipCode1))
                        .zipCode2(tuple.get(QTeam.team.zipCode2))
                        .address(tuple.get(QTeam.team.address))
                        .ddd(tuple.get(QTeam.team.ddd))
                        .tel(tuple.get(QTeam.team.tel))
                        .fax(tuple.get(QTeam.team.fax))
                        .homepage(tuple.get(QTeam.team.homepage))
                        .owner(tuple.get(QTeam.team.owner))
                        .stadiumId(tuple.get(QTeam.team.stadiumId.id)).build())
                .toList();

        return null;
    }

}
