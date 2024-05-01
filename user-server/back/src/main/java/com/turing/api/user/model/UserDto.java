package com.turing.api.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String job;
    private String token;
}
