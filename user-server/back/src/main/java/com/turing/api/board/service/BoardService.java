package com.example.demo.board.service;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import com.example.demo.common.service.CommandService;
import com.example.demo.common.service.QueryService;

import java.util.Optional;

public interface BoardService extends CommandService<Board>, QueryService<BoardDto> {

    default Board dtoToEntity(BoardDto dto) {
        return Board.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .description(dto.getDescription())
                .build();
    }

    default BoardDto entityToDto(Board ent) {
        return BoardDto.builder()
                .id(ent.getId())
                .title(ent.getTitle())
                .content(ent.getContent())
                .description(ent.getDescription())
//                .articles(ent.getArticles().stream().filter(i->(i.getId())))
                .build();
    }
}
