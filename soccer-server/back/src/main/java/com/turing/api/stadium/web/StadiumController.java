package com.turing.api.stadium.web;

import com.turing.api.enums.Messenger;
import com.turing.api.stadium.model.Stadium;
import com.turing.api.stadium.service.StadiumService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class StadiumController {
    private static StadiumService service;

    public ResponseEntity<Messenger> allList(){
        return service.allList();
    }

    public ResponseEntity<Messenger> findByTeamAndRegion(){
        return service.findByTeamAndRegion();
    }
    public ResponseEntity<Messenger> homeAndAway(){
        return service.homeAndAway();
    }
    public ResponseEntity<Messenger> noWayHome(){
        return service.noWayHome();
    }
}
