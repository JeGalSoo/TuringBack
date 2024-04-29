//package com.example.demo.common.security;
//
//import com.example.demo.common.component.Messenger;
//import com.example.demo.common.security.service.AuthService;
//import com.example.demo.user.model.UserDto;
//import com.example.demo.user.service.UserService;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@Slf4j
//@RestController
//@ApiResponses({
//        @ApiResponse(responseCode = "200", description = "OK"),
//        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
//        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
//        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
//})
//@RequiredArgsConstructor
//@RequestMapping(path="/api/auth")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class AuthController {
//    private final AuthService service;
//
//    @PostMapping(path = "/login")
//    public ResponseEntity<Messenger> login(@RequestBody UserDto userDto){
//        return ResponseEntity.ok(service.login(userDto));
//    }
//}
