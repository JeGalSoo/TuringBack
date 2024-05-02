package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerDAO {

    Player p(Long id);

    void insert(Player player);
    void update(Player player);
}
