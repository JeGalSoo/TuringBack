package com.turing.api.stadium.web;

import com.turing.api.stadium.model.StadiumDto;
import com.turing.api.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class StadiumRouter {
    private final StadiumRepository repository;

    @SuppressWarnings("unchecked")
    public List<?> execute(String q){
        return switch (q){
            case "1" -> repository.allList();
            case "11" -> repository.teamAndRegion();
            case "15" -> repository.scheduleDay();
            case "16" -> repository.homeAndAway();
            case "17" -> repository.noWayHome();
            default->null;
        };
    }
}
