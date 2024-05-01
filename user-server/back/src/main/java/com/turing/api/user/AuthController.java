package com.turing.api.user;


import com.turing.api.common.component.Messenger;
import com.turing.api.user.model.UserDto;
import com.turing.api.user.service.UserService;
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
@RequestMapping(path="/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    private final UserService service;


    @GetMapping( path = "/check")
    public ResponseEntity<Messenger> findByUsername(@RequestParam String username){
        log.info(username);
        return ResponseEntity.ok(service.existsByUsername(username));
    }


    @PostMapping(path = "/login")
    public ResponseEntity<Messenger> login(@RequestBody UserDto userDto){
        return ResponseEntity.ok(service.login(userDto));
    }
}
