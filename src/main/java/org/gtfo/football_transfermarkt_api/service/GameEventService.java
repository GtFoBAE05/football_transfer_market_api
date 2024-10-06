package org.gtfo.football_transfermarkt_api.service;

import org.gtfo.football_transfermarkt_api.entity.GameEvent;

import java.util.List;

public interface GameEventService {
    List<GameEvent> getGameEvent(Integer gameId);
}
