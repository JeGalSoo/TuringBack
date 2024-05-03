package com.turing.api.player.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public class PlayerDAOImpl implements PlayerDAO {


    @Override
    public Player p(Long id) {
        return null;
    }

    @Override
    public void insert(Player player) {

    }

    @Override
    public void update(Player player) {

    }
}
