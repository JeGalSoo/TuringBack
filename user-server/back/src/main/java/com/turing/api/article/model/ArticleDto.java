package com.turing.api.article.model;

import lombok.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private Long writerId;
    private Long boardId;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
