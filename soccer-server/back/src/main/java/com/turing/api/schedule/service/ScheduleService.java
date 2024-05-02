package com.turing.api.schedule.service;

import com.turing.api.enums.Messenger;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ScheduleService {

    ResponseEntity<Messenger> versus();

    ResponseEntity<Messenger> matchSchedule();
}
