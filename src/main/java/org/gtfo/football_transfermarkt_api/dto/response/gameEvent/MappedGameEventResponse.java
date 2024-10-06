package org.gtfo.football_transfermarkt_api.dto.response.gameEvent;

import lombok.*;
import org.gtfo.football_transfermarkt_api.dto.response.GameResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MappedGameEventResponse {
    private String id;

    private LocalDateTime date;

    private List<GameEventResponse> gameEvent;
}
