package org.gtfo.football_transfermarkt_api.repository;

import org.gtfo.football_transfermarkt_api.entity.GameEvent;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameEventRepository extends JpaRepository<GameEvent, String> {
    List<GameEvent> findAllByGameId(Integer gameId, Sort sort);
}
