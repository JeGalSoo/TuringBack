package com.turing.api.team.web;

import com.turing.api.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.turing.api.team.model.TeamDto;
import com.turing.api.team.service.TeamService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
})
@RequiredArgsConstructor
@RequestMapping(path="/api/team")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeamController {

    private final TeamRepository repository;
    private final TeamService service;

    @GetMapping("/sql1")
    public List<Map<String,Object>> sql1() {
        return repository.aaa();
    }

    @GetMapping("/sql10")
    public ResponseEntity<List<TeamDto>> sql10() {
        log.info("SQL 10 :");
        return ResponseEntity.ok(service.sql10());
    }

    @GetMapping("/sql12")
    public ResponseEntity<List<TeamDto>> sql12() {
        log.info("SQL 12 :");
        return ResponseEntity.ok(service.sql12());
    }

    @GetMapping("/sql13")
    public ResponseEntity<List<TeamDto>> sql13() {
        log.info("SQL 13 :");
        return ResponseEntity.ok(service.sql13());
    }

    @GetMapping("/sql19")
    public ResponseEntity<List<TeamDto>> sql19() {
        log.info("SQL 19 :");
        return ResponseEntity.ok(service.sql19());
    }

    @GetMapping("/sql20")
    public ResponseEntity<List<TeamDto>> sql20() {
        log.info("SQL 20 :");
        return ResponseEntity.ok(service.sql20());
    }

    @GetMapping("/sql21")
    public ResponseEntity<List<TeamDto>> sql21() {
        log.info("SQL 21 :");
        return ResponseEntity.ok(service.sql21());
    }

}
