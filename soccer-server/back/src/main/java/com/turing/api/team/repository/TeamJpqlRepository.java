package com.turing.api.team.repository;

import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;



@SuppressWarnings("hiding")
@Repository
public interface TeamJpqlRepository<Team> {

    @Query("""
        select new map(t.teamId,t.teamName ,round(avg(cast(p.height as double) ),2))
                                                 from teams t
                                                          join players p on t.teamId = p.teamId.teamId
                                                 where p.height!=' '
                                                 group by t.teamId,t.teamName
                                                 having avg(cast(p.height as double))< (select (avg(cast(p.height as double)))
                                                                                            from teams t
                                                                                            join players p on t.teamId = p.teamId.teamId
                                                                                            where t.regionName='인천')  
                                                                       """)
    List<Map<String,Object>> aaa();

}
