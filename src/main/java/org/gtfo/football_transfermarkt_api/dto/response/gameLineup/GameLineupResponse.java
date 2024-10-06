package org.gtfo.football_transfermarkt_api.dto.response.gameLineup;

import lombok.*;
import org.gtfo.football_transfermarkt_api.dto.response.ClubResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameLineupResponse {
    private String id;

    private LocalDate date;

    private PlayerResponse player;

    private ClubResponse club;

    private String playerName;

    private String type;

    private String position;

    private String number;

    private Boolean teamCaptain;
}
