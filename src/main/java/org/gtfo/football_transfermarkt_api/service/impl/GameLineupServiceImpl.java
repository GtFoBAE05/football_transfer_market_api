package org.gtfo.football_transfermarkt_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.entity.GameLineup;
import org.gtfo.football_transfermarkt_api.repository.GameLineupRepository;
import org.gtfo.football_transfermarkt_api.service.GamelineupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameLineupServiceImpl implements GamelineupService {
    private final GameLineupRepository gameLineupRepository;

    @Override
    public List<GameLineup> getGameLineup(Integer gameId) {
        return gameLineupRepository.findAllByGameId(gameId);
    }
}
