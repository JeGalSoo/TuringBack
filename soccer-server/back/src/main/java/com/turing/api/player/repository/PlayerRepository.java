package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import com.turing.api.player.model.PlayerDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select distinct position from players ")
    List<PlayerDto> getAllPosition();

    @Query(value = "select distinct IFNULL(nullif(position,''),'newone') from players " ,nativeQuery = true)
    List<PlayerDto> getAllPositionincludeNull();

    @Query(value = "SELECT playerName FROM players WHERE position = 'GK' AND teamId = 'K02'", nativeQuery = true)
    List<PlayerDto> getAllByPositionAndTeamID();

    @Query(value = "SELECT p.playerName FROM players p WHERE p.position = 'GK' " +
            "AND p.teamId = p.teamId.teamId" ,nativeQuery = true)
    List<PlayerDto> getAllByPositionAndTeamName();

    @Query(value = "SELECT playerName FROM players WHERE playerName LIKE '고%' AND height >= '170' AND" +
            " teamId =(SELECT t FROM teams t WHERE t.regionName = '수원')", nativeQuery = true)
    List<PlayerDto> getAllByPlayerNameAndHeightAndTeam();

    @Query(value = """
            SELECT playerName 
            FROM players 
            WHERE playerName LIKE '고%' AND height >= '170' AND teamId ='K02'""",nativeQuery = true)
    List<PlayerDto> getAllByPlayerNameAndHeight();
}
