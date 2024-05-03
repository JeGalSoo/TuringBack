package com.turing.api.stadium.web;

import com.turing.api.enums.Messenger;
import com.turing.api.stadium.service.StadiumService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
})
@RequiredArgsConstructor
@RequestMapping(path="/api/stadium")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StadiumController {
    private static StadiumService service;
    private final StadiumRouter router;

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
    @GetMapping(path = "/search")
    public ResponseEntity<List<?>> search(@RequestParam(value = "q", required = true) String q,
                                    @RequestParam(value = "scheDate", required = false)String scheDate,
                                    @RequestParam(value = "gubun", required = false)String gubun,
                                    @RequestParam(value = "hometeamId", required = false)String hometeamId,
                                    @RequestParam(value = "awayteamId", required = false)String awayteamId,
                                    @RequestParam(value = "homeScore", required = false)Integer homeScore,
                                    @RequestParam(value = "awayScore", required = false)Integer awayScore
                                    ){
        log.info("입력받은 정보 : {}",q);
        List<?> o = router.execute(q);
        return ResponseEntity.ok(o);
    }

}
