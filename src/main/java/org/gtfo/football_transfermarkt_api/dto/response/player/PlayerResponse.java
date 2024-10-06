package org.gtfo.football_transfermarkt_api.dto.response.player;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponse {
    private Integer id;

    private String firstName;

    private String lastName;

    private String name;

    private Integer lastSeason;

    private Integer currentClubId;

    private String playerCode;

    private String countryOfBirth;

    private String cityOfBirth;

    private String countryOfCitizenship;

    private Instant dateOfBirth;

    private String subPosition;

    private String position;

    private String foot;

    private Integer heightInCm;

    private LocalDateTime contractExpirationDate;

    private String agentName;

    private String imageUrl;

    private String url;

    private String currentClubDomesticCompetitionId;

    private String currentClubName;

    private BigDecimal marketValueInEur;

    private BigDecimal highestMarketValueInEur;
}
