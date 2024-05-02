package com.turing.api.player.service;

import com.turing.api.player.model.Player;

public interface PalayerDao {
    Player p(Player player, Long id);
    void insert(Player player);
    void update(Player player);

}
