package org.gtfo.football_transfermarkt_api.dto.response.gameLineup;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameLineupSeparatedResponse {
    private LocalDate date;
    private GameLineupClubResponse clubA;
    private GameLineupClubResponse clubB;
}
