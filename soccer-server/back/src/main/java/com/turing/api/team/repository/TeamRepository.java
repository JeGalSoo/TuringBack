package com.turing.api.team.repository;

import com.turing.api.team.model.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@SuppressWarnings("rawtypes")
public interface TeamRepository extends JpaRepository<Team, Long>, TeamJpqlRepository {

        @Query( "SELECT t FROM teams t ORDER BY t.teamName DESC")
        List<Map<String, Team>> findAllTeams();

        // @Query("SELECT * FROM teams t JOIN players p ON t.team_id = p.team_id " +
        //                 "WHERE position =:position AND (regionName =:regionName1 OR regionName =:regionName2) "+
        //                 "ORDER BY regionName")
        // List<Map<String, Team>> findTeamByPosionAndRegionName(@Param("position") String position,
        //                 @Param("regionName1") String regionName1,
        //                 @Param("regionName2") String regionName2);

        // @Query("SELECT * FROM teams t JOIN players p ON t.team_id = p.team_id WHERE height >= 180 AND height < 183 " +
        //                 "AND ((regionName =:regionName1) OR (regionName =:regionName2)) " +
        //                 "ORDER BY height,regionName,playerNam        e")
        // List<Map<String, Team>> findTeamByPlayerHeightAndRegionName(@Param("regionName1") String regionName1,
        //                 @Param("regionName2") String regionName2);

        // @Query("SELECT teamName, playerName " +
        //                 "FROM teams t JOIN players p using (team_id) " +
        //                 "WHERE p.position ='' ORDER BY 1, 2")
        // List<Map<String, Team>> findAllTeamByPositionNull();

        // @Query("SELECT t.team_id, t.teamName, round(AVG(height),2) avg_hei " +
        //                 "FROM teams t JOIN players p USING (team_id) " +
        //                 "WHERE if(p.height = '',0,p.height) " +
        //                 "GROUP BY t.team_id having AVG(p.height) < (SELECT AVG(height) " +
        //                 "FROM teams JOIN players USING(team_id) WHERE regionName=:regionName1)")
        // List<Map<String, Team>> findTeamAngHeightByRegionName(@Param("regionName1") String regionName1);

        // @Query("SELECT (SELECT teamName FROM teams t WHERE p.team_id = t.team_id) AS teamName, playerName, " +
        //                 "backNo from players p WHERE position =:position")
        // List<Map<String, Team>> findTeamByPosition(@Param("position") String position);

        // @Query("SELECT (select teamName FROM teams t "+
        // "WHERE p.team_id=t.team_id) '소속팀명', playerName '선수명',backNo '백넘버' "+
        //                 "FROM players p ORDER BY height DESC LIMIT 5;")
        // List<Map<String, Team>> find5PlayerByHeight();

}
