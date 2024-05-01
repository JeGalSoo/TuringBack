package com.turing.api.stadium.repository;

import com.turing.api.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium,Long> {
    @Query(value = "select count(*) from stadiums s join teams t on t.stadium_id = s.stadium_id join schedules g on g.stadium_id=s.stadium_id join players p on p.team_id=t.team_id", nativeQuery = true)
    public Integer allList();

    @Query(value = "select concat(t.regionName,' ',team_name,' ',s.stadiumName) as team_name from stadiums s join teams t on s.stadiumId=t.stadiumId", nativeQuery = true )
    public String teamAndRegion();

    @Query(value = """
            select s.stadiumName, sc.scheDate,
                  (select t.teamName
                   from teams t
                   where sc.awayteamId = t.teamId) as awayteam,
                  (select t.teamName
                   from teams t
                   where sc.hometeamId = t.teamId) as hometeam
            from stadiums s
            join teams t on (t.stadiumId)
            join schedules sc on (sc.stadiumId)
            where sc.homeScore-sc.awayScore>=3""", nativeQuery = true)
    public List<?> homeAndAway();

    @Query(value = "select st.stadiumName,(select t.teamName\n" +
           "                     from teams t\n" +
           "                     where t.stadiumId = st.stadiumId)\n" +
           "from stadiums st", nativeQuery = true)
    public String noWayHome();


}
