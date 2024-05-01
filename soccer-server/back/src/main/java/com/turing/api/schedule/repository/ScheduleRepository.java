package com.turing.api.schedule.repository;

import com.turing.api.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    @Query(value = """
select (select team_name from team where team.team_id=schedule.awayteam_id) as awayteam_name,
            (select stadium_name from stadium where stadium.stadium_id=schedule.stadium_id) as stadium_name,
(select team_name from team where team.stadium_id=schedule.stadium_id) as team_name
    from schedule
    where sche_date=20120317""",nativeQuery = true)
    public String versus();

    @Query(value = """
SELECT (SELECT STADIUM_NAME FROM stadium s WHERE sc.stadium_id = s.stadium_id) STADIUM_NAME
	,sche_date
FROM schedule sc
WHERE sche_date LIKE '201205%';
            """, nativeQuery = true)
    public String matchSchedule();

}