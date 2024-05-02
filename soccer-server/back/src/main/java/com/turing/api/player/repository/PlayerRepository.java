package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import com.turing.api.player.service.PalayerDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> , PalayerDao, PlayerJpqlRepository {








}
