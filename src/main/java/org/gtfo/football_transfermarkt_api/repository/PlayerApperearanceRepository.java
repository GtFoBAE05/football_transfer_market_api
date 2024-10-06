package org.gtfo.football_transfermarkt_api.repository;

import org.gtfo.football_transfermarkt_api.entity.Player;
import org.gtfo.football_transfermarkt_api.entity.PlayerAppearance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlayerApperearanceRepository extends JpaRepository<PlayerAppearance, Integer>, JpaSpecificationExecutor<PlayerAppearance> {
    Page<PlayerAppearance> findByPlayerId(Integer playerId, Pageable pageable);
}
