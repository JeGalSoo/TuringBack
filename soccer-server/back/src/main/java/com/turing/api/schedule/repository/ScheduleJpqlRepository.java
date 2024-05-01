package com.turing.api.schedule.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@SuppressWarnings("hiding")
@Repository
public interface ScheduleJpqlRepository<Schedule> {


    @Query("""
select new map((select t.teamName from teams t where t.teamId=sc.awayteamId) as awayteamName,
            (select s.stadiumName from stadiums s where s.stadiumId=sc.stadiumId.stadiumId) as stadiumName,
(select t.teamName from teams t where t.stadiumId.stadiumId=sc.stadiumId.stadiumId) as teamName)
    from schedules sc
    where sc.scheDate = '20120317'""")
    public List<Map<String,String>> versus();

    @Query("""
SELECT new map((SELECT s.stadiumName FROM stadiums s WHERE sc.stadiumId.stadiumId = s.stadiumId) STADIUM_NAME
	,sc.scheDate)
FROM schedules sc
WHERE sc.scheDate LIKE '201205%'
            """)
    public List<Map<String,String>> matchSchedule();

}
