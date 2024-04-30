package com.turing.api.stadium.service;

import com.turing.api.enums.Messenger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StadiumService {
    ResponseEntity<Messenger> allList();

    ResponseEntity<Messenger> findByTeamAndRegion();

    ResponseEntity<Messenger> homeAndAway();

    ResponseEntity<Messenger> noWayHome();
}
