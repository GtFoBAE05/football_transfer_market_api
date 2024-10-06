package org.gtfo.football_transfermarkt_api.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClubResponse {
    private Integer id;

    private String clubCode;

    private String name;

    private CompetitionResponse domesticCompetition;

    private String totalMarketValue;

    private Integer squadSize;

    private BigDecimal averageAge;

    private Integer foreignersNumber;

    private BigDecimal foreignersPercentage;

    private Integer nationalTeamPlayers;

    private String stadiumName;

    private Integer stadiumSeats;

    private String netTransferRecord;

    private String coachName;

    private Integer lastSeason;

    private String url;
}
