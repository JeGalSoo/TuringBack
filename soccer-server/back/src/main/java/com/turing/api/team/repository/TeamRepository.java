package com.turing.api.team.repository;


import com.turing.api.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@SuppressWarnings("rawtypes")
public interface TeamRepository extends JpaRepository<Team, Long>, TeamJpqlRepository, TeamDao {
}
