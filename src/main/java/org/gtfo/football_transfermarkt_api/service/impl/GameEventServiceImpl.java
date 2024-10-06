package org.gtfo.football_transfermarkt_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.entity.GameEvent;
import org.gtfo.football_transfermarkt_api.repository.GameEventRepository;
import org.gtfo.football_transfermarkt_api.service.GameEventService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameEventServiceImpl implements GameEventService {
    private final GameEventRepository gameEventRepository;

    @Override
    public List<GameEvent> getGameEvent(Integer gameId) {
        return gameEventRepository.findAllByGameId(gameId, Sort.by(Sort.Direction.ASC, "minute"));
    }
}
