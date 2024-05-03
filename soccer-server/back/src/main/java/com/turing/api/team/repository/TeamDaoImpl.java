package com.turing.api.team.repository;

import java.util.List;
import java.util.Map;

import com.turing.api.team.model.Team;
import com.turing.api.team.service.TeamService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@PersistenceContext
@RequiredArgsConstructor
public class TeamDaoImpl implements TeamDao {

    private final EntityManager em;

    @Override
    public Team find(Class<Team>  team, long l) {
       return em.find(team, 1L);
    }

    @Override
    public void insert(Team team) {
       em.persist(team);
    }

    @Override
    public void update(Team team) {
        em.persist(team);
    }

}

