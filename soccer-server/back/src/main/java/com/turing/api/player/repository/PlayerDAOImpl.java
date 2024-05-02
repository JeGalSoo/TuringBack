package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@PersistenceContext
@RequiredArgsConstructor
public class PlayerDAOImpl implements PlayerDAO {

    private final EntityManager entityManager;

    @Override
    public Player p(Long id) {

        return entityManager.find(Player.class,id);
    }

    @Override
    public void insert(Player player) {

    }

    @Override
    public void update(Player player) {

    }
}
