package org.gtfo.football_transfermarkt_api.service;

import org.gtfo.football_transfermarkt_api.dto.response.PlayerAppearanceResponse;
import org.springframework.data.domain.Page;

public interface PlayerAppearanceService {
    Page<PlayerAppearanceResponse> getPlayerAppearanceByPlayerId(Integer playerId, Integer page, Integer size, String sortBy);
}
