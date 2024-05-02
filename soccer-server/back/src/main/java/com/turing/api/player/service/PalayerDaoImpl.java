package com.turing.api.player.service;

import com.turing.api.player.model.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
public class PalayerDaoImpl implements PalayerDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Player p(Player player, Long id) {
        return entityManager.find(Player.class, 1L);
    }

    @Override
    public void insert(Player player) {
        entityManager.persist(player);
    }

    @Override
    public void update(Player player) {
        entityManager.persist(player);
    }
}
