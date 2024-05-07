package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> , PlayerDao, PlayerJpqlRepository {








}
