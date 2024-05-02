package com.turing.api.team.repository;

import com.turing.api.team.model.Team;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@SuppressWarnings("rawtypes")
public interface TeamRepository extends JpaRepository<Team, Long>, TeamJpqlRepository, TeamDao {



}
