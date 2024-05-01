package com.turing.api.board.service;


import com.turing.api.board.model.Board;
import com.turing.api.board.model.BoardDto;
import com.turing.api.common.service.CommandService;
import com.turing.api.common.service.QueryService;

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
