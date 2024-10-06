package org.gtfo.football_transfermarkt_api.repository.specification;

import org.gtfo.football_transfermarkt_api.entity.Club;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;


public class ClubSpecification {

    public static Specification<Club> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), name + "%");
    }

    public static Specification<Club> hasSquadSizeEqual(Integer squadSize) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("squadSize"), squadSize);
    }

    public static Specification<Club> hasSquadSizeLessThan(Integer squadSize) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("squadSize"), squadSize);
    }

    public static Specification<Club> hasSquadSizeLessThanEqual(Integer squadSize) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("squadSize"), squadSize);
    }

    public static Specification<Club> hasSquadSizeGreaterThan(Integer squadSize) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("squadSize"), squadSize);
    }

    public static Specification<Club> hasSquadSizeGreaterThanEqual(Integer squadSize) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("squadSize"), squadSize);
    }

    public static Specification<Club> hasSquadSizeBetween(Integer minSquadSize, Integer maxSquadSize) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("squadSize"), minSquadSize, maxSquadSize);
    }

    public static Specification<Club> hasAverageAgeEqual(BigDecimal averageAge) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("averageAge"), averageAge);
    }

    public static Specification<Club> hasAverageAgeLessThan(BigDecimal averageAge) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("averageAge"), averageAge);
    }

    public static Specification<Club> hasAverageAgeLessThanEqual(BigDecimal averageAge) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("averageAge"), averageAge);
    }

    public static Specification<Club> hasAverageAgeGreaterThan(BigDecimal averageAge) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("averageAge"), averageAge);
    }

    public static Specification<Club> hasAverageAgeGreaterThanEqual(BigDecimal averageAge) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("averageAge"), averageAge);
    }

    public static Specification<Club> hasAverageAgeBetween(BigDecimal minAverageAge, BigDecimal maxAverageAge) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("averageAge"), minAverageAge, maxAverageAge);
    }

}
