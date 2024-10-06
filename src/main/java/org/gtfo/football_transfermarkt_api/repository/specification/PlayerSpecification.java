package org.gtfo.football_transfermarkt_api.repository.specification;

import org.gtfo.football_transfermarkt_api.entity.Player;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class PlayerSpecification {

    public static Specification<Player> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), name.toLowerCase() + "%");
    }

    public static Specification<Player> hasPosition(String position) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("position")), position.toLowerCase());
    }

    public static Specification<Player> hasFoot(String foot) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("foot")), foot.toLowerCase());
    }

    public static Specification<Player> hasHeightEqual(Integer height) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("height"), height);
    }

    public static Specification<Player> hasHeightLessThan(Integer height) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("height"), height);
    }

    public static Specification<Player> hasHeightLessThanEqual(Integer height) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("height"), height);
    }

    public static Specification<Player> hasHeightGreaterThan(Integer height) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("height"), height);
    }

    public static Specification<Player> hasHeightGreaterThanEqual(Integer height) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("height"), height);
    }

    public static Specification<Player> hasHeightBetween(Integer minHeight, Integer maxHeight) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("height"), minHeight, maxHeight);
    }


    public static Specification<Player> hasMarketValueEqual(BigDecimal marketValue) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("marketValueInEur"), marketValue);
    }

    public static Specification<Player> hasMarketValueLessThan(BigDecimal marketValue) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("marketValueInEur"), marketValue);
    }

    public static Specification<Player> hasMarketValueLessThanEqual(BigDecimal marketValue) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("marketValueInEur"), marketValue);
    }

    public static Specification<Player> hasMarketValueGreaterThan(BigDecimal marketValue) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("marketValueInEur"), marketValue);
    }

    public static Specification<Player> hasMarketValueGreaterThanEqual(BigDecimal marketValue) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("marketValueInEur"), marketValue);
    }

    public static Specification<Player> hasMarketValueBetween(BigDecimal minMarketValue, BigDecimal maxMarketValue) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("marketValueInEur"), minMarketValue, maxMarketValue);
    }


}
