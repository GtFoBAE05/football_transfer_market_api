package org.gtfo.football_transfermarkt_api.repository.specification;

import jakarta.persistence.criteria.Predicate;
import org.gtfo.football_transfermarkt_api.entity.Game;
import org.springframework.data.jpa.domain.Specification;

public class GameSpecification {
    public static Specification<Game> findGame(Integer clubId){
        return (root, query, criteriaBuilder) -> {
            Predicate homeClubPredicate = criteriaBuilder.equal(root.get("homeClub").get("id"), clubId);
            Predicate awayClubPredicate = criteriaBuilder.equal(root.get("awayClub").get("id"), clubId);

            return criteriaBuilder.or(homeClubPredicate, awayClubPredicate);
        };
    }
}
