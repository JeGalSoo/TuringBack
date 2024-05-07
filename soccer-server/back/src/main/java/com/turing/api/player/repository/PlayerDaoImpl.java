package com.turing.api.player.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.api.player.model.PlayerDto;
import com.turing.api.player.model.QPlayer;
import com.turing.api.player.model.QPlayerDto;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class PlayerDaoImpl implements PlayerDao {

    private final JPAQueryFactory factory;
    private final QPlayer player = QPlayer.player;

    @Override
    public List<PlayerDto> getAllPlayers() {
        return factory.select(
                        new QPlayerDto(
                                player.id,
                                player.playerId,
                                player.ePlayerName,
                                player.playerName,
                                player.joinYyyy,
                                player.position,
                                player.backNo,
                                player.nickname,
                                player.nation,
                                player.birthDate,
                                player.solar,
                                player.height,
                                player.weight,
                                player.teamId.teamId))
                .from(player).fetch();
    }

    @Override
    public List<String> getNo2Dsl() {
        return factory.select(
                        player.position
                ).distinct()
                .from(player)
                .orderBy(player.position.desc())
                .offset(0)
                .limit(5)
                .fetch();
    }

    @Override
    public List<PlayerDto> getNo3Dsl() {
        return factory.selectDistinct(
                        new QPlayerDto(
                                new CaseBuilder()
                                        .when(player.position.eq(" ")).then("NewOne")
                                        .otherwise(player.position).as("position")))
                .from(player)
                .fetch();
//        return null;

    }

    @Override
    public List<PlayerDto> getNo4Dsl() {
        return factory.select(
                        new QPlayerDto(player.playerName))
                .from(player)
                .where(player.position.eq("GK"),
                        player.teamId.teamId.eq("K02"))
                .fetch();
    }

    @Override
    public List<PlayerDto> getNo5Dsl() {
        return factory.select(new QPlayerDto(player.playerName))
                .from(player)
                .where(player.playerName.like("고%"),
                        player.height.goe("170"),
                        player.teamId.teamId.eq("K02") )
                .fetch();
    }

    @Override
    public List<PlayerDto> getNo5HM1Dsl() {
        return factory.select(new QPlayerDto(player.playerName))
                .from(player)
                .where(player.playerName.like("고%"),
                        player.height.goe("170"),
                        player.teamId.regionName.eq("수원"))
                .fetch();
    }

    @Override
    public List<PlayerDto> getNo6Dsl() {
//        return factory.select(new QPlayerDto(player.playerName))
//                .from(player)
//                .where(player.position.eq("MF"),
//                        player.height.between("170", "180"),
//                        player.teamId.teamName.eq() )
//
//                .fetch();
        return null;
    }

    @Override
    public List<PlayerDto> getNo7Dsl() {
        return null;
    }

    @Override
    public List<PlayerDto> getNo8Dsl() {
        return null;
    }

    @Override
    public List<PlayerDto> getNo9Dsl() {
        return null;
    }

    @Override
    public List<PlayerDto> getNo18Dsl() {
        return null;
    }

    @Override
    public List<PlayerDto> getNo22Dsl() {
        return null;
    }


}
