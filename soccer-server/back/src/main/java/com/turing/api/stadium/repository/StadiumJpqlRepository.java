package com.turing.api.stadium.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("hiding")
@Repository
public interface StadiumJpqlRepository<Stadium> {
    @Query("select new map(count(*)) from stadiums s join teams t on t.stadiumId.stadiumId = s.stadiumId join schedules g on g.stadiumId.stadiumId=s.stadiumId join players p on p.teamId.teamId=t.teamId")
    public List<Map<String, Integer>> allList();

    @Query("select new map(concat(t.regionName,' ',t.teamName,' ',s.stadiumName) as teamName) from stadiums s join teams t on s.stadiumId=t.stadiumId.stadiumId")
    public List<Map<String, String>> teamAndRegion();

    @Query("""
            SELECT new map(s.stadiumName, sc.scheDate,
                   (SELECT t.teamName
                    FROM teams t
                    WHERE t.teamId=sc.hometeamId) as home,
                   (SELECT t.teamName
                    FROM teams t
                    WHERE t.teamId=sc.awayteamId) as away)
            FROM stadiums s
                     JOIN schedules sc ON s.stadiumId = sc.stadiumId.stadiumId
            WHERE (sc.homeScore-sc.awayScore)>= 3""")
    public List<Map<String, String>> homeAndAway();

    @Query("""
select p.player_name 선수이름,
        p.position 포지션,
        concat(t.region_name,'[]',t.team_name) 팀명,
        s.stadium_name 스타디움,
        sc.sche_date 경기날짜
from stadium s
    join schedule sc on s.stadium_id = sc.stadium_id
    join team t on s.hometeam_id = t.team_id
    join player p on t.team_id = p.team_id
where sc.sche_date = '20120317' and t.team_name='스틸러스' and p.position = 'GK';
""")
    public List<Map<String,String>> scheduleDay();

    @Query("""
select new map(st.stadiumName,(select t.teamName
        from teams t
        where t.stadiumId.stadiumId = st.stadiumId))
    from stadiums st""")
    public List<Map<String, String>> noWayHome();

}
