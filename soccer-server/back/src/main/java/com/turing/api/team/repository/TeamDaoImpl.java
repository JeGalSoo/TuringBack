package com.turing.api.team.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import com.turing.api.player.model.QPlayer;
import com.turing.api.team.model.QTeam;
import com.turing.api.team.model.QTeamDto;
import com.turing.api.team.model.Team;
import com.turing.api.team.model.TeamDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.sqm.CastType;
import org.springframework.expression.spel.ast.Projection;

import static com.querydsl.core.group.GroupBy.*;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Slf4j
public class TeamDaoImpl implements TeamDao {

    private final JPAQueryFactory factory;
    private final QTeam team = QTeam.team;

    @Override
    public List<TeamDto> getAllTeamsDsl() {
        return factory.select(
                        new QTeamDto(
                                team.id,
                                team.teamId,
                                team.regionName,
                                team.teamName,
                                team.eTeamName,
                                team.origYyyy,
                                team.zipCode1,
                                team.zipCode2,
                                team.address,
                                team.ddd,
                                team.tel,
                                team.fax,
                                team.homepage,
                                team.owner,
                                team.stadiumId.id))
                .from(QTeam.team)
                .offset(5)
                .fetch();
    }

    // 1 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
    @Override
    public List<TeamDto> getNo1Dsl() {
//        Map<String, Object> resultmap = factory
        return factory
                .select(new QTeamDto(
                        team.id,
                        team.teamId,
                        team.regionName,
                        team.teamName,
                        team.eTeamName,
                        team.origYyyy,
                        team.zipCode1,
                        team.zipCode2,
                        team.address,
                        team.ddd,
                        team.tel,
                        team.fax,
                        team.homepage,
                        team.owner,
                        team.stadiumId.id))
                .from(QTeam.team)
                .orderBy(team.teamName.desc())
                .offset(1)
                .limit(5)
                .fetch()
//                .transform(list(
//                        GroupBy.groupBy(team.id).list(
//                                Projections.constructor(
//                                        QTeam.class,
//                                        team.id,
//                                        team.teamId,
//                                        team.regionName,
//                                        team.teamName,
//                                        team.eTeamName,
//                                        team.origYyyy,
//                                        team.zipCode1,
//                                        team.zipCode2,
//                                        team.address,
//                                        team.ddd,
//                                        team.tel,
//                                        team.fax,
//                                        team.homepage,
//                                        team.owner,
//                                        team.stadiumId.id))
//
//                ))
                ;

//        resultmap.keySet().stream()
//                .map(resultmap::get)
//                .collect(toList());

//        return resultmap;
    }

    // 10 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인 선수를 출력하시오.
    // 단 , 팀명, 선수명 오름차순 정렬.
    @Override
    public List<TeamDto> getNo10Dsl(String position1, String regionName1, String regionName2) {
        return factory
                .select(new QTeamDto(
                        team.id,
                        team.teamId,
                        team.regionName,
                        team.teamName,
                        team.eTeamName,
                        team.origYyyy,
                        team.zipCode1,
                        team.zipCode2,
                        team.address,
                        team.ddd,
                        team.tel,
                        team.fax,
                        team.homepage,
                        team.owner,
                        team.stadiumId.id))
                .from(QTeam.team)
                .join(QPlayer.player)
                .where(
                        QPlayer.player.position.eq(position1)
                                .and(getNo10DslPredicate(regionName1, regionName2)))
                .offset(1)
                .limit(5)
                .fetch();
    }

    private BooleanBuilder getNo10DslPredicate(String regionName1, String regionName2) {
        return new BooleanBuilder()
                .or(QTeam.team.regionName.eq(regionName1))
                .or(QTeam.team.regionName.eq(regionName2));
    }

    // 12 수원팀(K02) 과 대전팀(K10) 선수들 중 키가 180 이상 183 이하인 선수들 키, 팀명, 사람명 오름차순
    @Override
    public List<?> getNo12Dsl(String regionName1, String regionName2) {
        return factory
                .select(team.teamName,
                        QPlayer.player.height,
                        QPlayer.player.playerName)
                .from(QTeam.team)
                .join(QPlayer.player)
                .where(
                        QPlayer.player.height.between("180", "183")
                                .and(getNo10DslPredicate(regionName1, regionName2)))
                .orderBy(
                        QPlayer.player.height.desc(),
                        team.regionName.desc(),
                        QPlayer.player.playerName.desc())
                .offset(1)
                .limit(5)
                .fetch();
    }

    // 13 모든 선수들 중 포지션을 배정 받지 못한 선수들의 팀명과 선수이름 출력 둘다 오름차순
    @Override
    public List<?> getNo13Dsl() {

        return factory
                    .select(QTeam.team.teamName,QPlayer.player.height,QPlayer.player.playerName)
//                            new QPlayer(QPlayer.player.playerName))
                .from(QTeam.team)
                .join(QPlayer.player)
                .on(QPlayer.player.teamId.id.eq(QTeam.team.id))
//                .where(QPlayer.player.position.isNotEmpty()) 476
//                .where(QPlayer.player.position.isNotNull()) 479
//                .where(QPlayer.player.position.eq(" ")) 2
//                .where(QPlayer.player.position.eq("")) 2
                .where(QPlayer.player.position.isNull()
                        .or(QPlayer.player.position.eq(""))
                        .or(QPlayer.player.position.isEmpty()))
                .orderBy(
                        team.id.desc(),
                        QPlayer.player.playerName.asc())
                .offset(1)
                .fetch();
    }

    // 19 평균키가 인천 유나이티스팀('K04')의 평균키 보다 작은 팀의 팀ID, 팀명, 평균키 추출
    // 인천 유나이티스팀의 평균키 -- 176.59
    // 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에 포함되지 않도록 하세요.
    @Override
    public List<TeamDto> getNo19Dsl(String regionName1) {
//        return factory
//                .select(
//                        team.id,
//                        team.teamName,
//                        avg(CastType.INTEGER(QPlayer.player.height).as("hei"))
//                .from(QTeam.team)
//                .join(QPlayer.player)
//                .where(QPlayer.player.position.isNull())
//                .orderBy(
//                        team.id.desc(),
//                        QPlayer.player.playerName.desc())
//                .offset(1)
//                .limit(5)
//                .fetch();
        return null;
    }

    // 20 포지션이 MF 인 선수들의 소속팀명 및 선수명, 백넘버 출력
    @Override
    public List<?> getNo20Dsl(String position1) {
        log.info("getNo20Dsl : {}", position1);
//        List<Tuple> tuples = factory
        return factory
                .select(QTeam.team.teamName,
                        QTeam.team.teamId)
                .select(Projections.fields(
                        team.teamName,
                        QPlayer.player.playerName,
                        QPlayer.player.backNo))
                .from(QTeam.team)
                .join(QPlayer.player)
                .on(QPlayer.player.teamId.id.eq(QTeam.team.id))
                .where(QPlayer.player.position.eq(position1))
                .offset(1)
                .fetch();

//        List<TeamDto> dtos = new ArrayList<>();
//        for (Tuple tuple : tuples) {
//            TeamDto dto = new TeamDto();
//            dto.setTeamName(tuple.get(team.teamName));
//            // playerName과 backNo는 Tuple에 포함되지만 TeamDto에는 추가하지 않음
//            dtos.add(dto);
//        }


//        return dtos;
    }

    // 21 가장 키큰 선수 5명 소속팀명 및 선수명, 백넘버 출력, 단 키 값이 없으면 제외
    @Override
    public List<?> getNo21Dsl() {
        return factory
                .select(
                        team.teamName,
                        JPAExpressions.select(
                                        QPlayer.player.playerName.as("PLAYERNAME"),
                                        QPlayer.player.backNo.as("BACKNO"))
                                .from(QPlayer.player))
                .from(QTeam.team)
                .join(QPlayer.player).on(QPlayer.player.teamId.id.eq(QTeam.team.id))
                .offset(1)
                .limit(5)
                .fetch();
    }


}
