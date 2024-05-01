package com.turing.api.article.model;

import com.turing.api.board.model.Board;
import com.turing.api.common.BaseEntity;
import com.turing.api.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
@ToString(exclude = {"id"})
@Entity(name = "articles")
public class Article extends BaseEntity {
    @Id
    @Column(name = "article_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public static Article of(String title, String content){
        Article article = new Article();
        article.title = title;
        article.content = content;

        return article;
    }

}