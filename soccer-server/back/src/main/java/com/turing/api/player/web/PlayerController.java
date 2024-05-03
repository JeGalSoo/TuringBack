package com.turing.api.player.web;


import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import com.turing.api.player.service.PlayerService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@ApiResponses({
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "200", description = "SUCCESS"),
})
@RequiredArgsConstructor
@RequestMapping("/api/player")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class PlayerController {

    private final PlayerRouter router;
    private final PlayerService playerService;

    @GetMapping( "/search")
    public ResponseEntity<List<?>> searchPlayer(
            @RequestParam(name = "q",required = true) String q,
            @RequestParam(name = "playerName",required = false) String playerName,
            @RequestParam(name = "position",required = false) String position,
            @RequestParam(name = "teamId",required = false) String teamId
    ) {
        log.info("입력받은 정보 : {}",q);
        List<?> o = router.execute(q, playerName, position, teamId);
        log.info("반환정보 : {}",o);
        return ResponseEntity.ok(o);
    }


}
