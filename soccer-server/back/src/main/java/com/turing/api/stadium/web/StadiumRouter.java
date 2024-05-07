package com.turing.api.stadium.web;

import com.turing.api.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class StadiumRouter {
    private final StadiumRepository repository;

    @SuppressWarnings("unchecked")
    public List<?> execute(String q){
        return switch (q){
            case "stadiums-list" -> repository.getAllStadiumsDsl();
            case "11" -> repository.No1Dsl();
            case "15" -> repository.No11Dsl();
            case "16" -> repository.No15Dsl();
            case "17" -> repository.No16Dsl();
            case "18" -> repository.No17Dsl();
            default->null;
        };
    }
}
