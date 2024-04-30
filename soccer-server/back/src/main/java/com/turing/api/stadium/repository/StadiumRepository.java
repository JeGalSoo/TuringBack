package com.turing.api.stadium.repository;

import com.turing.api.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium,Long> {
    @Query("select count(*) from stadiums s join teams t on t.stadiumId = s.stadiumId join schedules g on g.stadiumId=s.stadiumId join players p on p.teamId=t.teamId")
    public List<?> allList();

    @Query("select concat(t.regionName,' ',team_name,' ',s.stadiumName) as team_name from stadiums s join teams t on s.stadiumId=t.stadiumId")
    public List<?> byTeamAndRegion();

    @Query("""
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
            where sc.homeScore-sc.awayScore>=3""")
    public List<?> homeAndAway();

    @Query("select st.stadiumName,(select t.teamName\n" +
           "                     from teams t\n" +
           "                     where t.stadiumId = st.stadiumId)\n" +
           "from stadiums st")
    public List<?> noWayHome();


}
