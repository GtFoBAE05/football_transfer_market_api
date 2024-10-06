package org.gtfo.football_transfermarkt_api.service;

import org.gtfo.football_transfermarkt_api.dto.response.gameEvent.GameEventResponse;
import org.gtfo.football_transfermarkt_api.dto.response.gameEvent.MappedGameEventResponse;
import org.gtfo.football_transfermarkt_api.dto.response.gameLineup.GameLineupSeparatedResponse;
import org.gtfo.football_transfermarkt_api.dto.response.GameResponse;
import org.springframework.data.domain.Page;

public interface GameService {
    Page<GameResponse> getClubGame(Integer clubId, Integer page, Integer size);

    GameLineupSeparatedResponse getGameLineup(Integer gameId);

    MappedGameEventResponse getGameEvent(Integer gameId);
}
