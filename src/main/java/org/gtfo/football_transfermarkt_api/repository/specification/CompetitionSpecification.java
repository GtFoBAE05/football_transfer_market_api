package org.gtfo.football_transfermarkt_api.repository.specification;

import org.gtfo.football_transfermarkt_api.entity.Competition;
import org.springframework.data.jpa.domain.Specification;

public class CompetitionSpecification {
    public static Specification<Competition> hasCompetitionName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name.toUpperCase() );
    }

    public static Specification<Competition> hasSubtype(String subtype) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("subType"),  subtype );
    }

    public static Specification<Competition> hasType(String type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"),  type );
    }

    public static Specification<Competition> hasCountryName(String countryName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("countryName"),  countryName );
    }

    public static Specification<Competition> isMajorNationalLeague(boolean isMajorNationalLeague) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isMajorNationalLeague"),  isMajorNationalLeague );
    }
}
