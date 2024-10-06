package org.gtfo.football_transfermarkt_api.repository;

import org.gtfo.football_transfermarkt_api.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>, JpaSpecificationExecutor<Player> {

    Page<Player> findByCurrentClubId(Integer clubId, Pageable pageable);

}
