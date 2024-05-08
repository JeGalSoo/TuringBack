package com.turing.api.stadium.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.api.player.model.QPlayer;
import com.turing.api.schedule.model.QSchedule;
import com.turing.api.stadium.model.QStadium;
import com.turing.api.stadium.model.QStadiumDto;
import com.turing.api.stadium.model.Stadium;
import com.turing.api.stadium.model.StadiumDto;
import com.turing.api.team.model.QTeam;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StadiumDaoImpl implements StadiumDao{
    private final JPAQueryFactory queryFactory;
    private final QStadium stadium = QStadium.stadium;

    @Override
    public List<StadiumDto> getAllStadiumsDsl() {
        return queryFactory.selectDistinct(
                new QStadiumDto(
                        stadium.id,
                        stadium.stadiumId,
                        stadium.stadiumName,
                        stadium.hometeamId,
                        stadium.seatCount,
                        stadium.address,
                        stadium.ddd,
                        stadium.tel))
                .from(stadium)
                .orderBy(stadium.stadiumName.asc())
                .offset(1)
                .limit(5)
                .fetch();
    }

    @Override
    public Stadium p(Long id) {
        return null;
    }

    @Override
    public void insert(Stadium stadium) {

    }

    @Override
    public void update(Stadium stadium) {

    }

    @Override
    public List<Long> No1Dsl() {
        return queryFactory.select(
                stadium.count())
                .from(QStadium.stadium)
                .join(QStadium.stadium.teams,QTeam.team)
                .join(QStadium.stadium.schedules, QSchedule.schedule)
                .fetch();
    }

    @Override
    public List<String> No11Dsl() {
        return queryFactory.select(
                QTeam.team.regionName.concat(" ").concat(QTeam.team.teamName).concat(" ").concat(QStadium.stadium.stadiumName).as("teamName"))
                .from(QStadium.stadium)
                .join(QStadium.stadium.teams,QTeam.team)
                .fetch();
    }

    @Override
    public List<Tuple> No15Dsl() {
        return queryFactory.select(
                stadium.stadiumName, QSchedule.schedule.scheDate,
                        (queryFactory.select(QTeam.team.teamName)
                                .from(QTeam.team)
                                .where(QTeam.team.teamId.eq(QSchedule.schedule.hometeamId).as("home"))),
                        (queryFactory.select(QTeam.team.teamName)
                                .from(QTeam.team)
                                .where(QTeam.team.teamId.eq(QSchedule.schedule.awayteamId).as("away"))))
                .from(stadium)
                .join(stadium.schedules,QSchedule.schedule)
                .where(QSchedule.schedule.homeScore.subtract(QSchedule.schedule.awayScore).goe(3))
                .fetch();
    }

    @Override
    public List<Tuple> No16Dsl() {
        return queryFactory.select(QPlayer.player.playerName.as("선수이름"),
                QPlayer.player.position.as("포지션"),
                QTeam.team.regionName.concat("[]").concat(QTeam.team.teamName).as("팀명"),
                stadium.stadiumName.as("스타디움"),QSchedule.schedule.scheDate.as("경기날짜"))
                .from(stadium)
                .join(stadium.schedules,QSchedule.schedule)
                .join(stadium.teams,QTeam.team)
                .where(QSchedule.schedule.scheDate.eq("20120317").and(QTeam.team.teamName.eq("스틸러스")).and(QPlayer.player.position.eq("GK")))
                .fetch();
    }

    @Override
    public List<StadiumDto> No17Dsl() {
        return null;
    }


}
