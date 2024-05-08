package com.turing.api.player.web;


import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import com.turing.api.player.service.PlayerService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/api/players")
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
            @RequestParam(name = "teamId",required = false) String teamId,
            Pageable pageable
    ) {
        log.info("MY-INFO : Controller searchPlayer q is {}", q);
        log.info("MY-INFO : Controller searchPlayer page is {}", pageable.getPageNumber());
        log.info("MY-INFO : Controller searchPlayer limit is {}", pageable.getPageSize());
        log.info("MY-INFO : Controller searchPlayer sortField is {}", pageable.getSort().toString());

        // nowPage, rowCount, pageSize, blockSize 외부주입.. count, size 1 부터, number 는 0부터

//        int totalCount = Integer.parseInt(String.valueOf(playerService.countAllPlayers()));
        int totalCount = 455;
        int pageSize = 10;
        int BLOCK_SIZE = 10;

        int startRow = 0;
        int endRow = 0;

        int startPage = 0;
        int endPage = 0;

        int nextBlock = 0;
        int prevBlock = 0;

        int pageNum = 40;
        int blockNum = (pageNum+pageSize)%pageSize ==0 ? ((pageNum+pageSize)/pageSize)-1 :(pageNum+pageSize)/pageSize ;

        int blockCount = 0;
        int pageCount = 0;

        boolean existPrev = false;
        boolean existNext = false;

        blockCount = totalCount % (pageSize*BLOCK_SIZE) == 0 ? totalCount/(pageSize*BLOCK_SIZE) : (totalCount/(pageSize*BLOCK_SIZE))+1;
        pageCount = totalCount % pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize)+1;;
        startRow = (pageNum-1)*pageSize;
        endRow = pageNum != pageCount ? startRow+pageSize-1 : startRow + (totalCount % pageSize);

        startPage = (blockNum-1)*BLOCK_SIZE+1;
        endPage = blockNum != blockCount ? startPage+BLOCK_SIZE-1 : startPage +(totalCount % (pageSize*BLOCK_SIZE))%10 ;

        existPrev = blockNum == 1 ? false : true;
        existNext = blockNum == blockCount ? false : true;
        nextBlock = blockNum+1;
        prevBlock = blockNum-1;


        log.info("MY-INFO : Controller searchPlayer totalCount is {}", totalCount);
        log.info("MY-INFO : Controller searchPlayer pageCount is {}", pageCount);
        log.info("MY-INFO : Controller searchPlayer blockCount is {}", blockCount);
        log.info("MY-INFO : Controller searchPlayer startRow is {}", startRow);
        log.info("MY-INFO : Controller searchPlayer endRow is {}", endRow);
        log.info("MY-INFO : Controller searchPlayer blockNum is {}", blockNum);
        log.info("MY-INFO : Controller searchPlayer startPage is {}", startPage);
        log.info("MY-INFO : Controller searchPlayer endPage is {}", endPage);
        log.info("MY-INFO : Controller searchPlayer existPrev is {}", existPrev);
        log.info("MY-INFO : Controller searchPlayer existNext is {}", existNext);
        log.info("MY-INFO : Controller searchPlayer nextBlock is {}", nextBlock);
        log.info("MY-INFO : Controller searchPlayer prevBlock is {}", prevBlock);
        log.info("입력받은 q : ",q);
        List<?> o = router.execute(q, playerName, position, teamId);
        return ResponseEntity.ok(o);
    }


}
