package org.gtfo.football_transfermarkt_api.repository.specification;

import org.gtfo.football_transfermarkt_api.entity.Club;
import org.gtfo.football_transfermarkt_api.entity.Player;
import org.gtfo.football_transfermarkt_api.entity.Transfer;
import org.springframework.data.jpa.domain.Specification;

public class TransferSpecification {
    public static Specification<Transfer> playerIdSpecification(Player player) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("playerId"), player);
    }

    public static Specification<Transfer> fromClubIdSpecification(Club club) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("fromClubId"), club);
    }

    public static Specification<Transfer> toClubIdSpecification(Club club) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("toClubId"), club);
    }
}
