package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> , PlayerJpqlRepository {


}
