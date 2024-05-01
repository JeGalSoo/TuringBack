package com.turing.api.schedule.service;

import com.turing.api.enums.Messenger;
import com.turing.api.schedule.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private static ScheduleRepository repository;

    @Override
    public ResponseEntity<Messenger> versus() {
        return null;
    }

    @Override
    public ResponseEntity<Messenger> matchSchedule() {
        return null;
    }
}
