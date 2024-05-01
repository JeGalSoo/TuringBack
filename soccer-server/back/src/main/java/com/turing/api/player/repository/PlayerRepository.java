package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.util.List;
=======
import org.springframework.stereotype.Repository;
>>>>>>> bkh

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

//    @Query(value = "select distinct position from players ")
//    List<PlayerDto> getAllPosition();
//
//    @Query(value = "select distinct IFNULL(nullif(position,''),'newone') from players ")
//    List<PlayerDto> getAllPositionincludeNull();
//
//    @Query(value = "SELECT playerName FROM players WHERE position = 'GK' AND teamId = 'K02'")
//    List<PlayerDto> getAllByPositionAndTeamID();
//
//    @Query(value = "SELECT p.playerName FROM players p WHERE p.position = 'GK' " +
//            "AND p.teamId = p.teamId.teamId")
//    List<PlayerDto> getAllByPositionAndTeamName();
}
