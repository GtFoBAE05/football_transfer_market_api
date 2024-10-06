package org.gtfo.football_transfermarkt_api.repository;

import org.gtfo.football_transfermarkt_api.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionsRepository extends JpaRepository<Competition, String>, JpaSpecificationExecutor<Competition> {
}
