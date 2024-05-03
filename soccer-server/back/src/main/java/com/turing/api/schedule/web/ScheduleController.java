package com.turing.api.schedule.web;

import com.turing.api.enums.Messenger;
import com.turing.api.schedule.service.ScheduleService;
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
@RequestMapping(path = "/api/schedule")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScheduleController {
    private final ScheduleService service;
    private final ScheduleRouter router;

    @GetMapping(path = "/search")
    public ResponseEntity<List<?>> search(@RequestParam(value = "q", required = true) String q,
                                                           @RequestParam(value = "stadiumId", required = false)String stadiumId,
                                                           @RequestParam(value = "stadiumName", required = false)String stadiumName,
                                                           @RequestParam(value = "hometeamId", required = false)String hometeamId,
                                                           @RequestParam(value = "seatCount", required = false)String seatCount,
                                                           @RequestParam(value = "tel", required = false)String tel
    ){
        log.info("입력받은 정보 : {}",q);
        List<?> o = router.execute(q);
        return ResponseEntity.ok(o);
    }
}
