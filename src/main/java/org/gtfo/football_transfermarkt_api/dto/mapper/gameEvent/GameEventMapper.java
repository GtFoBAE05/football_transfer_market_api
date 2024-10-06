package org.gtfo.football_transfermarkt_api.dto.mapper.gameEvent;

import org.gtfo.football_transfermarkt_api.dto.mapper.player.PlayerMapper;
import org.gtfo.football_transfermarkt_api.dto.response.gameEvent.GameEventResponse;
import org.gtfo.football_transfermarkt_api.dto.response.gameEvent.MappedGameEventResponse;
import org.gtfo.football_transfermarkt_api.entity.GameEvent;
import org.gtfo.football_transfermarkt_api.entity.Player;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class GameEventMapper {
    public static MappedGameEventResponse gameEventToGameEventResponse(String id, LocalDateTime date, List<GameEventResponse> gameEvent){
        return MappedGameEventResponse.builder()
                .id(id)
                .date(date)
                .gameEvent(gameEvent)
                .build();
    }
}
