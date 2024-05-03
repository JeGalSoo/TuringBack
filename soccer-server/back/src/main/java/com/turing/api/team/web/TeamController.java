package com.turing.api.team.web;

import com.turing.api.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private final TeamRouter router;


    // @GetMapping("/sql10")
    // public ResponseEntity<List<TeamDto>> findTeamByPosionAndRegionName() {
    //     log.info("SQL 10 :");
    //     return ResponseEntity.ok(service.findTeamByPosionAndRegionName());
    // }

    // @GetMapping("/sql12")
    // public ResponseEntity<List<TeamDto>> findTeamByPlayerHeightAndRegionName() {
    //     log.info("SQL 12 :");
    //     return ResponseEntity.ok(service.findTeamByPlayerHeightAndRegionName());
    // }

    // @GetMapping("/sql13")
    // public ResponseEntity<List<TeamDto>> findAllTeamByPositionNull() {
    //     log.info("SQL 13 :");
    //     return ResponseEntity.ok(service.findAllTeamByPositionNull());
    // }

    // @GetMapping("/sql19")
    // public ResponseEntity<List<TeamDto>> findTeamAngHeightByRegionName() {
    //     log.info("SQL 19 :");
    //     return ResponseEntity.ok(service.findTeamAngHeightByRegionName());
    // }

    // @GetMapping("/sql20")
    // public ResponseEntity<List<TeamDto>> findTeamByPosition() {
    //     log.info("SQL 20 :");
    //     return ResponseEntity.ok(service.findTeamByPosition());
    // }

    // @GetMapping("/sql21")
    // public ResponseEntity<List<TeamDto>> find5PlayerByHeight() {
    //     log.info("SQL 21 :");
    //     return ResponseEntity.ok(service.find5PlayerByHeight());
    // }

    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> searchTeam(
            @RequestParam(value = "q", required = true) String q,
            @RequestParam(value = "position", required = false) String position1,
            @RequestParam(value = "regionName1", required = false) String regionName1,
            @RequestParam(value = "regionName2", required = false) String regionName2) {
        log.info("Controller searchTeam q : {}, position1 : {}, regionName1 : {}, regionName2 : {}", q,position1,regionName1,regionName2);
        List<Map<String, Object>> list = router.execute(q, position1,regionName1,regionName2);
       
        log.info("list size : {}",list.size());
        return ResponseEntity.ok(list);
    }

}
