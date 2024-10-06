package org.gtfo.football_transfermarkt_api.repository;

import org.gtfo.football_transfermarkt_api.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer>, JpaSpecificationExecutor<Club> {
}
