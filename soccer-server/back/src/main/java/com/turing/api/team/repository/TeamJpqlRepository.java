package com.turing.api.team.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.turing.api.team.model.Team;

@Repository
@SuppressWarnings("rawtypes")
public interface TeamJpqlRepository extends JpaRepository<Team, Long> {

    // 1 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
    @Query("""
            SELECT new map(t.id, t.teamId, t.regionName, t.teamName,
            t.eTeamName, t.origYyyy, t.zipCode1, t.zipCode2, t.address, t.ddd, t.tel,
            t.fax, t.homepage, t.owner, t.stadiumId.stadiumId)
            FROM teams t ORDER BY t.teamName DESC""")
    List<Map<String, Object>> findAllTeams();

    // 10 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인 선수를 출력하시오.
    // 단 , 팀명, 선수명 오름차순 정렬.
    @Query("""
                SELECT new map(t.id, t.teamId, t.regionName, t.teamName,
                t.eTeamName, t.origYyyy, t.zipCode1, t.zipCode2, t.address, t.ddd, t.tel,
                t.fax, t.homepage, t.owner, t.stadiumId.stadiumId)
                FROM teams t JOIN players p ON t.teamId = p.teamId.teamId
            WHERE position =:position1 AND (regionName =:regionName1 OR regionName
            =:regionName2)
            ORDER BY t.regionName""")
    List<Map<String, Object>> findTeamByPosionAndRegionName(
            @Param("position1") String position1,
            @Param("regionName1") String regionName1,
            @Param("regionName2") String regionName2);

    // 12 수원팀(K02) 과 대전팀(K10) 선수들 중 키가 180 이상 183 이하인 선수들 키, 팀명, 사람명 오름차순
    @Query("""
            SELECT new map(t.teamName,p.height, p.playerName)
            FROM teams t JOIN players p ON t.teamId = p.teamId.teamId
            WHERE (p.height >= '180') AND p.height  < '183'
              AND ((t.regionName =:regionName1) OR (t.regionName =:regionName2))
             ORDER BY p.height, t.regionName, p.playerName""")
    List<Map<String, Object>> findTeamByPlayerHeightAndRegionName(
            @Param("regionName1") String regionName1,
            @Param("regionName2") String regionName2);

    // 13 모든 선수들 중 포지션을 배정 받지 못한 선수들의 팀명과 선수이름 출력 둘다 오름차순
    @Query("""
            SELECT new map(t.teamName, p.playerName)
            FROM teams t JOIN players p ON t.teamId = p.teamId.teamId
            WHERE p.position =null ORDER BY t.id, t.teamName""")
    List<Map<String, Object>> findAllTeamByPositionNull();

    // 19 평균키가 인천 유나이티스팀('K04')의 평균키 보다 작은 팀의 팀ID, 팀명, 평균키 추출
    // 인천 유나이티스팀의 평균키 -- 176.59
    // 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에 포함되지 않도록 하세요.
//    @Query("""
//              SELECT new map(t.teamId AS teamId, t.teamName AS teamName,
//               CAST(AVG(p.height ,2) AS DOUBLE) AS avgHei)
//            FROM teams t JOIN players p ON t.teamId = p.teamId.teamId
//            Where p.height != ''
//            GROUP BY t.teamId HAVING AVG(cast(p.height AS DOUBLE)) <
//             (SELECT AVG(cast(p.height AS DOUBLE))
//              FROM teams
//               WHERE t.regionName='수원')""")
//    List<Map<String, Object>> findTeamAngHeightByRegionName(@Param("regionName1") String regionName1);

    // 20 포지션이 MF 인 선수들의 소속팀명 및 선수명, 백넘버 출력
    @Query("""
            SELECT
            new map(
            (SELECT p.teamId.teamName
            FROM teams t
            WHERE t.teamId =p.teamId.teamId)
            AS teamName, playerName As playerName, backNo AS backNo )
            FROM players p
            WHERE p.position = :position1""")
    List<Map<String, Object>> findTeamByPosition(@Param("position1") String position1);

    // 21 가장 키큰 선수 5명 소속팀명 및 선수명, 백넘버 출력, 단 키 값이 없으면 제외
    @Query("""
            SELECT
            new map(
            (SELECT p.teamId.teamName
            FROM teams t
            WHERE t.teamId =p.teamId.teamId)
            AS teamName, playerName AS playerName, backNo AS backNo)
                    FROM players p ORDER BY height DESC LIMIT 5""")
    List<Map<String, Object>> find5PlayerByHeight();

}
