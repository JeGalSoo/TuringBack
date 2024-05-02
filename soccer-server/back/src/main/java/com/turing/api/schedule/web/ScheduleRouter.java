package com.turing.api.schedule.web;

import com.turing.api.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class ScheduleRouter {
    private final ScheduleRepository repository;

    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> execute(String q){
        log.info("Executing query: " + q);
        return switch (q){
            case "14" -> repository.versus();
            case "23" -> repository.matchSchedule();
            default->null;
        };
    }
}
