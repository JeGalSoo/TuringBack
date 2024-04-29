package com.example.demo.board.model;

import com.example.demo.article.model.Article;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
