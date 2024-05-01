package com.turing.api.board.model;

import lombok.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class BoardDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Long articles;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
