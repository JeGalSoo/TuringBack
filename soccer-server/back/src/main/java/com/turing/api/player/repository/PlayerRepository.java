package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
<<<<<<< HEAD
import com.turing.api.player.model.PlayerDto;
import java.util.List;

import com.turing.api.player.service.PalayerDao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
=======

>>>>>>> bkh
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> , PalayerDao {
=======
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> , PlayerJpqlRepository, PlayerDAO {
>>>>>>> bkh








}
