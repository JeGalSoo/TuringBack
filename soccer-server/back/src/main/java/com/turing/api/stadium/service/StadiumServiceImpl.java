package com.turing.api.stadium.service;

import com.turing.api.enums.Messenger;
import com.turing.api.stadium.repository.StadiumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StadiumServiceImpl implements StadiumService{
    private static StadiumRepository repository;
    @Override
    public ResponseEntity<Integer> allList() {
//        List list = new ArrayList();
//        list.add(repository.allList());
        return null;
    }

    @Override
    public ResponseEntity<Messenger> findByTeamAndRegion() {
        return null;
    }

    @Override
    public ResponseEntity<Messenger> homeAndAway() {
        return null;
    }

    @Override
    public ResponseEntity<Messenger> noWayHome() {
        return null;
    }
}
