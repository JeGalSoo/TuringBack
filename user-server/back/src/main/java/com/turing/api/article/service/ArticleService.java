package com.turing.api.article.service;


import com.turing.api.article.model.Article;
import com.turing.api.article.model.ArticleDto;
import com.turing.api.board.model.Board;
import com.turing.api.common.service.CommandService;
import com.turing.api.common.service.QueryService;
import com.turing.api.user.model.User;

import java.util.List;

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