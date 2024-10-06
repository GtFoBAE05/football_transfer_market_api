package org.gtfo.football_transfermarkt_api.dto.response.gameLineup;

import lombok.*;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameLineupPlayerResponse {
    private String id;

    private PlayerResponse player;

    private String type;

    private String position;

    private String number;

    private Boolean teamCaptain;
}
