package com.turing.api.team.repository;


import com.turing.api.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface TeamRepository extends JpaRepository<Team, Long> , TeamJpqlRepository,TeamDao{



    // @Query(value = "SELECT * FROM teams t ORDER BY t.team_name", nativeQuery=true)
    // @Query(value = "SELECT * FROM teams ", nativeQuery=true)
    // List<TeamDto> findAll();

//     @Query("SELECT * FROM teams t JOIN player p ON t.team_id = p.team_id"+
// "WHERE position :=position AND (region_name :=regionName1 OR region_name :=regionName2) ORDER BY region_name")
//     List<Team> sql10
//     (@Param("position") String position, @Param("regionName1") String regionName1,@Param("regionName2") String regionName2);

//     @Query("SELECT * FROM teams t JOIN player p ON t.team_id = p.team_id WHERE height >= 180 AND height < 183" +
//                 "AND ((region_name :=regionName1) OR (region_name :=regionName2))"+
//                 "ORDER BY height,region_name,player_name")
//     List<Team> sql12(@Param("regionName1")String regionName1, @Param("regionName2")String regionName2);

//     @Query("SELECT team_name, player_name" + 
//                 "FROM teams t JOIN player p using (team_id)" +
//                 "WHERE p.position = '' ORDER BY 1, 2")
//     List<Team> sql13();

//     @Query("SELECT t.team_id, t.team_name, round(AVG(height),2) avg_hei" + 
//                 "FROM teams t JOIN player p USING (team_id)" + 
//                 "WHERE if(p.height = '',0,p.height)" + 
//                 "GROUP BY t.team_id having AVG(p.height) < (SELECT AVG(height)" + 
//                 "FROM teams JOIN player USING(team_id) WHERE region_name:=regionName)")
//     List<Team> sql19(@Param("regionName")String regionName);

//     @Query("SELECT (SELECT team_name FROM teams t WHERE p.team_id = t.team_id) AS team_name, player_name," +
//                 "backNo from players p WHERE position :=position")
//     List<Team> sql20(@Param("position") String position);

//     @Query("SELECT (select team_name FROM teams t WHERE p.team_id=t.team_id) '소속팀명', player_name '선수명',back_no '백넘버'" +
//             "FROM players p ORDER BY height DESC LIMIT 5;")
//     List<Team> sql21();


}
