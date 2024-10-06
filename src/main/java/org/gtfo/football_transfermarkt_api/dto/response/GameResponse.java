package org.gtfo.football_transfermarkt_api.dto.response;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {
    private Integer id;

    private CompetitionResponse competition;

    private String season;

    private String round;

    private LocalDateTime date;

    private ClubResponse homeClub;

    private ClubResponse awayClub;

    private Integer homeClubGoals;

    private Integer awayClubGoals;

    private Integer homeClubPosition;

    private Integer awayClubPosition;

    private String homeClubManagerName;

    private String awayClubManagerName;

    private String stadium;

    private Integer attendance;

    private String referee;

    private String url;

    private String homeClubFormation;

    private String awayClubFormation;

    private String homeClubName;

    private String awayClubName;

    private String aggregate;

    private String competitionType;
}
