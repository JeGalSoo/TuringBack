package com.turing.api.stadium.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.api.player.model.QPlayer;
import com.turing.api.stadium.model.QStadium;
import com.turing.api.stadium.model.Stadium;
import com.turing.api.stadium.model.StadiumDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StadiumDAOImpl implements StadiumDao{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<StadiumDto> getAllPlayers() {
        queryFactory.select(
                QStadium.stadium.id,
                QStadium.stadium.stadiumId,
                        QStadium.stadium.address,
                        QStadium.stadium.ddd,
                        QStadium.stadium.hometeamId,
                        QStadium.stadium.seatCount,
                        QStadium.stadium.stadiumName,
                        QStadium.stadium.tel)
                .from(QStadium.stadium)
                .fetch()
                .stream()
                .map(tuple -> StadiumDto.builder()
                        .id(tuple.get(QStadium.stadium.id))
                        .stadiumId(tuple.get(QStadium.stadium.stadiumId))
                        .address(tuple.get(QStadium.stadium.address))
                        .ddd(tuple.get(QStadium.stadium.ddd))
                        .hometeamId(tuple.get(QStadium.stadium.hometeamId))
                        .seatCount(tuple.get(QStadium.stadium.seatCount))
                        .stadiumName(tuple.get(QStadium.stadium.stadiumName))
                        .tel(tuple.get(QStadium.stadium.tel))
                        .build().toString());
        return null;
    }

    @Override
    public Stadium p(Long id) {
        return null;
    }

    @Override
    public void insert(Stadium player) {

    }

    @Override
    public void update(Stadium player) {

    }
}
