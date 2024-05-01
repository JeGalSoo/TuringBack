package com.turing.api.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turing.api.team.model.Team;

@Repository
@SuppressWarnings("rawtypes")
public interface TeamJpqlRepository extends JpaRepository<Team, Long>{
    
}
