package org.gtfo.football_transfermarkt_api.service;

import org.gtfo.football_transfermarkt_api.entity.GameLineup;

import java.util.List;

public interface GamelineupService {
    List<GameLineup> getGameLineup(Integer gameId);
}
