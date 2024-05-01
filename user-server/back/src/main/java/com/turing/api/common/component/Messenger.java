package com.turing.api.common.component;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Messenger {
    private String message;
    private int status;
    private String accessToken;
    private String refreshToken;
    private Long id;
}