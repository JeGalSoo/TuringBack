package com.turing.api.schedule.repository;


import com.turing.api.schedule.model.ScheduleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleDAO {

    List<ScheduleDto> getAllSchedules();

}
