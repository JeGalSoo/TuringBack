package com.turing.api.stadium.web;

import com.turing.api.enums.Messenger;
import com.turing.api.stadium.service.StadiumService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
})
@RequiredArgsConstructor
@RequestMapping(path="/api/search/stadium")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StadiumController {
    private static StadiumService service;

    @GetMapping("/list")
    public ResponseEntity<Integer> allList(){
        return service.allList();
    }

    @GetMapping("/combine")
    public ResponseEntity<Messenger> teamAndRegion(){
        return service.findByTeamAndRegion();
    }

    @GetMapping("/versus")
    public ResponseEntity<Messenger> homeAndAway(){
        return service.homeAndAway();
    }

    @GetMapping("/noHome")
    public ResponseEntity<Messenger> noWayHome(){
        return service.noWayHome();
    }
}
