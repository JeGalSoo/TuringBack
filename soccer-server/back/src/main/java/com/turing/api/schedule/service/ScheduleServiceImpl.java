package com.turing.api.schedule.service;

import com.turing.api.schedule.repository.ScheduleRepository;

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
