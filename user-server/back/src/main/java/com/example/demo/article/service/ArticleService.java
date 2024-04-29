package com.example.demo.article.service;

import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import com.example.demo.board.model.Board;
import com.example.demo.common.service.CommandService;
import com.example.demo.common.service.QueryService;
import com.example.demo.user.model.User;

import java.util.List;
import java.util.Optional;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto dto) {
        return Article.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .board(Board.builder()
                        .id(dto.getBoardId())
                        .build())
                .writer(User.builder()
                        .id(dto.getWriterId())
                        .build())
                .build();
    }

    default ArticleDto entityToDto(Article ent) {
        return ArticleDto.builder()
                .id(ent.getId())
                .title(ent.getTitle())
                .content(ent.getContent())
                .writerId(ent.getWriter().getId())
                .regDate(ent.getRegDate())
                .modDate(ent.getModDate())
                .build();
    }

    List<ArticleDto> findAllByBoardId(Long id);
}