package com.turing.api.article;

import com.turing.api.article.model.ArticleDto;
import com.turing.api.article.service.ArticleService;
import com.turing.api.common.component.Messenger;
import com.turing.api.common.component.pagination.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
})
@RequiredArgsConstructor
@RequestMapping(path="/api/articles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArticleController {
    private final ArticleService service;

    @PostMapping(path = "/save")
        public ResponseEntity<Messenger> save(@RequestBody ArticleDto article){
        return ResponseEntity.ok(service.save(article));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id){
        return ResponseEntity.ok(service.deleteById(id));
    }

    @PostMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody ArticleDto article){
        return ResponseEntity.ok(service.modify(article));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ArticleDto>> findAll(PageRequestVo vo){
        log.info("findAll request : {}", vo);
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping( path = "/detail")
    public ResponseEntity<List<ArticleDto>> findAllByBoarId(@RequestParam Long id){
        System.out.println("여기입니다여기1111111111111111111234"+id);
        return ResponseEntity.ok(service.findAllByBoardId(id));
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
