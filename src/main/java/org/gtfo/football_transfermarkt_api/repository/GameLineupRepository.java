package org.gtfo.football_transfermarkt_api.repository;

import org.gtfo.football_transfermarkt_api.entity.GameLineup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameLineupRepository extends JpaRepository<GameLineup, String> {
    List<GameLineup> findAllByGameId(Integer gameId);
}
