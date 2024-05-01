package com.turing.api.board;

import com.turing.api.board.model.Board;
import com.turing.api.board.model.BoardDto;
import com.turing.api.board.service.BoardService;
import com.turing.api.common.component.Messenger;
import com.turing.api.common.component.pagination.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
})
@RequiredArgsConstructor
@RequestMapping(path="/api/boards")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {
    private final BoardService service;

    @PostMapping(path = "/save")
    public ResponseEntity<Messenger> save(@RequestBody Board board){
        return ResponseEntity.ok(service.save(board));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id){
        return ResponseEntity.ok(service.deleteById(id));
    }

    @PostMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody Board board){
        return ResponseEntity.ok(service.modify(board));
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto>> findAll(PageRequestVo vo){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping( path = "/detail")
    public ResponseEntity<Optional<BoardDto>> findById(@RequestParam Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }

    @PostMapping(path = "/check-id")
    public ResponseEntity<Boolean> existsById(@RequestParam Long id){
        return ResponseEntity.ok(service.existsById(id));
    }

}
