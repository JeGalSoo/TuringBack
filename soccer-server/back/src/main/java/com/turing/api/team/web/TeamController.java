package com.turing.api.team.web;

import com.turing.api.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
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
@RequestMapping(path="/api/teams")
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
    public ResponseEntity<List<?>> searchTeam(
            @RequestParam(value = "q", required = true) String q,
//            Pageable pageable,
            @RequestParam(value = "position", required = false) String position1,
            @RequestParam(value = "regionName1", required = false) String regionName1,
            @RequestParam(value = "regionName2", required = false) String regionName2
            ) {

//        log.info("MY-INFO : Controller searchPlayer q is {}", q);
//        log.info("MY-INFO : Controller searchPlayer page is {}", pageable.getPageNumber());
//        log.info("MY-INFO : Controller searchPlayer limit is {}", pageable.getPageSize());
//        log.info("MY-INFO : Controller searchPlayer sortField is {}", pageable.getSort().toString());
//
//        // nowPage, rowCount, pageSize, blockSize 외부주입.. count, size 1 부터, number 는 0부터
//
//        int totalCount = 2340;
//        int pageCount = 0;
//        int blockCount = 0;
//        int startRow = 0;
//        int endRow = 0;
//        int blockNum = 0;
//        int startPage = 0;
//        int endPage = 0;
//        int pageSize = 10;
//        int pageNum = 1;
//        int BLOCK_SIZE = 10;
//        boolean existPrev = false;
//        boolean existNext = false;
//        int nextBlock = 0;
//        int prevBlock = 0;
//
//        pageCount = (totalCount % pageSize != 0) ? (totalCount / pageSize)+1 : totalCount / pageSize;
//        startRow = (pageNum-1)*pageSize;
//        endRow = (pageNum==pageCount) ? totalCount -1 : startRow + pageSize -1;
//        blockCount = (pageCount % BLOCK_SIZE != 0) ? (pageCount / BLOCK_SIZE)+1 : pageCount / BLOCK_SIZE;
//        blockNum = (pageNum - 1) / BLOCK_SIZE;
//        startPage = blockNum * BLOCK_SIZE + 1;
//        endPage = ((blockNum + 1) != blockCount) ? startPage + (BLOCK_SIZE -1) : pageCount;
//        existPrev = blockNum != 0;
//        existNext = (blockNum + 1) != blockCount;
//        nextBlock = startPage + BLOCK_SIZE;
//        prevBlock = startPage - BLOCK_SIZE;
//
//        log.info("MY-INFO : Controller searchPlayer totalCount is {}", totalCount);
//        log.info("MY-INFO : Controller searchPlayer pageCount is {}", pageCount);
//        log.info("MY-INFO : Controller searchPlayer blockCount is {}", blockCount);
//        log.info("MY-INFO : Controller searchPlayer startRow is {}", startRow);
//        log.info("MY-INFO : Controller searchPlayer endRow is {}", endRow);
//        log.info("MY-INFO : Controller searchPlayer blockNum is {}", blockNum);
//        log.info("MY-INFO : Controller searchPlayer startPage is {}", startPage);
//        log.info("MY-INFO : Controller searchPlayer endPage is {}", endPage);
//        log.info("MY-INFO : Controller searchPlayer existPrev is {}", existPrev);
//        log.info("MY-INFO : Controller searchPlayer existNext is {}", existNext);
//        log.info("MY-INFO : Controller searchPlayer nextBlock is {}", nextBlock);
//        log.info("MY-INFO : Controller searchPlayer prevBlock is {}", prevBlock);

        log.info("Controller searchTeam q : {}, position1 : {}, regionName1 : {}, regionName2 : {}", q,position1,regionName1,regionName2);
        List<?> list = router.execute(q, position1,regionName1,regionName2);
       
        log.info("list size : {}",list.size());
        return ResponseEntity.ok(list);
    }

}
