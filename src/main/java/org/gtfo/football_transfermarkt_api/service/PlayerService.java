package org.gtfo.football_transfermarkt_api.service;

import org.gtfo.football_transfermarkt_api.dto.response.PlayerAppearanceResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.SimplifiedPlayerResponse;
import org.gtfo.football_transfermarkt_api.entity.Player;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlayerService {
    PlayerResponse getPlayerById(Integer playerId);

    Player getPlayer(Integer playerId);

    SimplifiedPlayerResponse getPlayerByIdAsSimplifiedPlayerResponse(Integer playerId);

    Page<PlayerResponse> searchPlayer(Integer page, Integer size, String name,
                                      List<String> position, String foot, List<String> height,
                                      List<String> marketValue, String sortBy);

    Page<PlayerResponse> findPlayerWithClubId(Integer clubId, Integer page, Integer size, String sortBy);

    Page<PlayerAppearanceResponse> findPlayerAppearance(Integer playerId, Integer page, Integer size, String sortBy);
}
