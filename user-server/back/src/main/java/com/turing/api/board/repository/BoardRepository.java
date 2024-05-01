package com.turing.api.board.repository;

import com.turing.api.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByTitle();
}
