package com.turing.api.stadium.web;

import com.turing.api.common.model.Box;
import com.turing.api.common.model.PageDTO;
import com.turing.api.common.service.PageService;
import com.turing.api.stadium.service.StadiumService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
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
@RequestMapping(path="/api/stadiums")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StadiumController {
    private final StadiumService service;
    private final StadiumRouter router;
    private final PageService pageService;

    @GetMapping(path = "/search")
    public ResponseEntity<List<?>> search(@RequestParam(value = "q") String q, Pageable pageable)
    {
        log.info("MY-INFO : Controller searchPlayer page is {}", pageable.getPageNumber());
        log.info("MY-INFO : Controller searchPlayer limit is {}", pageable.getPageSize());
        log.info("MY-INFO : Controller searchPlayer sortField is {}", pageable.getSort().toString());
        log.info("입력받은 정보 : {}",q);


        List<?> o = router.execute(q);

        Box box = new Box();
        box.setPageDTO(pageService.getPageDTO(o.size(),pageable.getPageNumber()));
        box.setList(o);
        return ResponseEntity.ok(o);
    }
}
