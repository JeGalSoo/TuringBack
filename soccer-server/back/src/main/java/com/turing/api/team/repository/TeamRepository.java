package com.turing.api.team.repository;

import com.turing.api.player.model.Player;
import com.turing.api.player.repository.PlayerJpqlRepository;
import com.turing.api.player.service.PalayerDao;
import com.turing.api.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> , TeamJpqlRepository {


}
