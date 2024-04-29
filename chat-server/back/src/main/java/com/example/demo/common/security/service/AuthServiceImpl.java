package com.example.demo.common.security.service;

import com.example.demo.common.component.Messenger;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Log4j2
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
    private final UserRepository re;

    @Override
    public Messenger login(UserDto userDto) {
        boolean flag = re.findByUsername(userDto.getUsername()).getPassword().equals(userDto.getPassword());
        User user = re.findByUsername(userDto.getUsername());
        return Messenger.builder()
                .message(flag? "SUCCESS":"FILURE")
                .accessToken(flag?createToken(userDto):"None")
                .build();
    }

    @Override
    public String createToken(UserDto user) {
        Claims claims = (Claims) Jwts.claims();
        claims.put("username", user.getUsername());
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tokenValidTime = now.plusSeconds(24*60*60*1000);

        String token = Jwts.builder()
//        return Jwts.builder()
                .claims()
                .issuer("turing.co.kr")
                .add("sub","User Auth")
                .add("exp",tokenValidTime)
                .add("userId",user.getId())
                .add("username",user.getUsername())
                .add("job","admin")
                .and()

                .compact();

        log.info("로그인 성공으로 발급된 토근 :"+token);
        return token;
    }
}
