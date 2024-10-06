package org.gtfo.football_transfermarkt_api.dto.response.gameEvent;

import lombok.*;
import org.gtfo.football_transfermarkt_api.dto.response.GameResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.SimplifiedPlayerResponse;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameEventResponse {
    private String gameEventId;

    private Integer minute;

    private String type;

    private String clubName;

    private SimplifiedPlayerResponse player;

    private String description;

    private SimplifiedPlayerResponse playerInId;

    private SimplifiedPlayerResponse playerAssistId;
}
