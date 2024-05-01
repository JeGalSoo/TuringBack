package com.turing.api.board.service;

import com.turing.api.board.model.Board;
import com.turing.api.board.model.BoardDto;
import com.turing.api.board.repository.BoardRepository;
import com.turing.api.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository re;


    @Override
    public Messenger save(Board board) {
        if(existsById(board.getId()))re.save(board);
        return new Messenger();
    }

    @Override
    public Messenger deleteById(Long id) {
        re.deleteById(id);
        return new Messenger();
    }

    @Override
    public Messenger modify(Board board) {
        return new Messenger();
    }

    @Override
    public List<BoardDto> findAll() {
        return re.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        BoardDto dto = entityToDto(Objects.requireNonNull(re.findById(id).orElse(null)));
        return Optional.ofNullable(dto);
    }

    @Override
    public long count() {
        return re.count();
    }

    @Override
    public boolean existsById(Long id) {
        return re.existsById(id);
    }
}
