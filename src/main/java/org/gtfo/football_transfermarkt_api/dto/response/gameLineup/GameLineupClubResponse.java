package org.gtfo.football_transfermarkt_api.dto.response.gameLineup;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameLineupClubResponse {
    private String clubId;
    private String clubName;
    private List<GameLineupPlayerResponse> lineup;
}
