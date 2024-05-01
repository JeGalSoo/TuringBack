package com.turing.api.schedule.service;

<<<<<<< HEAD
import com.turing.api.schedule.repository.ScheduleRepository;

=======
import org.springframework.stereotype.Service;

@Service
>>>>>>> khj
public class ScheduleServiceImpl implements ScheduleService {
    private static ScheduleRepository repository;

    @Override
    public String versus() {
        return repository.versus();
    }

    @Override
    public String matchSchedule() {
        return repository.matchSchedule();
    }
}
