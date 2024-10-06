package org.gtfo.football_transfermarkt_api.dto.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
    public class PlayerAppearanceResponse {
        private String appearanceId;

        private GameResponse game;

        private ClubResponse playerClub;

        private ClubResponse playerCurrentClub;

        private LocalDate date;

        private String playerName;

        private CompetitionResponse competition;

        private Integer yellowCards;

        private Integer redCards;

        private Integer goals;

        private Integer assists;

        private Integer minutesPlayed;
    }
