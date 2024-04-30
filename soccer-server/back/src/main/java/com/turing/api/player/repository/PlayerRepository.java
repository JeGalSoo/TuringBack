package com.turing.api.player.repository;

import com.turing.api.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
