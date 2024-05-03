package com.turing.api.player.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import com.turing.api.player.model.QPlayer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@PersistenceContext
@RequiredArgsConstructor
public class PlayerDAOImpl implements PlayerDAO {

    private final JPAQueryFactory factory;

    @Override
    public List<PlayerDto> getAllPlayers() {

        return factory.select(
                QPlayer.player.id,
                QPlayer.player.playerId,
                QPlayer.player.ePlayerName,
                QPlayer.player.playerName,
                QPlayer.player.joinYyyy,
                QPlayer.player.position,
                QPlayer.player.backNo,
                QPlayer.player.nation,
                QPlayer.player.birthDate,
                QPlayer.player.solar,
                QPlayer.player.height,
                QPlayer.player.weight,
                QPlayer.player.teamId.teamId
                )
                .from(QPlayer.player)
                .fetch()
                .stream()
                .map(tuple -> PlayerDto.builder()
                        .id(tuple.get(QPlayer.player.id))
                        .playerId(tuple.get(QPlayer.player.playerId))
                        .playerName(tuple.get(QPlayer.player.playerName))
                        .ePlayerName(tuple.get(QPlayer.player.ePlayerName))
                        .joinYyyy(tuple.get(QPlayer.player.joinYyyy))
                        .position(tuple.get(QPlayer.player.position))
                        .backNo(tuple.get(QPlayer.player.backNo))
                        .nation(tuple.get(QPlayer.player.nation))
                        .birthDate(tuple.get(QPlayer.player.birthDate))
                        .solar(tuple.get(QPlayer.player.solar))
                        .height(tuple.get(QPlayer.player.height))
                        .weiget(tuple.get(QPlayer.player.weight))
                        .teamId(tuple.get(QPlayer.player.teamId.teamId))
                        .build())
                .toList();
    }







}
