package com.turing.api.stadium.repository;

import com.querydsl.core.Tuple;
import com.turing.api.stadium.model.Stadium;
import com.turing.api.stadium.model.StadiumDto;

import java.util.List;

public interface StadiumDao {
    List<StadiumDto> getAllStadiumsDsl();

    Stadium p(Long id);

    void insert(Stadium player);
    void update(Stadium player);

    List<Long> No1Dsl();

    List<String> No11Dsl();

    List<Tuple> No15Dsl();

    List<Tuple> No16Dsl();

    List<StadiumDto> No17Dsl();

    List<Long> countAllStadiums();
}
