package org.gtfo.football_transfermarkt_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.mapper.game.GameMapper;
import org.gtfo.football_transfermarkt_api.dto.mapper.gameEvent.GameEventMapper;
import org.gtfo.football_transfermarkt_api.dto.mapper.gameLineup.GameLineupMapper;
import org.gtfo.football_transfermarkt_api.dto.response.gameEvent.GameEventResponse;
import org.gtfo.football_transfermarkt_api.dto.response.gameEvent.MappedGameEventResponse;
import org.gtfo.football_transfermarkt_api.dto.response.gameLineup.GameLineupSeparatedResponse;
import org.gtfo.football_transfermarkt_api.dto.response.GameResponse;
import org.gtfo.football_transfermarkt_api.entity.Game;
import org.gtfo.football_transfermarkt_api.entity.GameEvent;
import org.gtfo.football_transfermarkt_api.repository.GameRepository;
import org.gtfo.football_transfermarkt_api.repository.specification.GameSpecification;
import org.gtfo.football_transfermarkt_api.service.GameService;
import org.gtfo.football_transfermarkt_api.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final GameLineupServiceImpl gameLineupService;
    private final GameEventServiceImpl gameEventService;
    private final PlayerService playerService;

    @Override
    public Page<GameResponse> getClubGame(Integer clubId, Integer page, Integer size) {
        Specification<Game> specification = Specification.where(GameSpecification.findGame(clubId));

        if (page<=1){
            page = page-1;
        }
        Pageable pageable = PageRequest.of(page, size);

        return gameRepository.findAll(specification, pageable).map(
                game -> GameMapper.gameToGameResponse(game)
        );
    }

    @Override
    public GameLineupSeparatedResponse getGameLineup(Integer gameId) {
        gameRepository.findById(gameId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found")
        );

        return GameLineupMapper.gameLineupToGameLineupSeparatedResponse(gameLineupService.getGameLineup(gameId));
    }

    @Override
    public MappedGameEventResponse getGameEvent(Integer gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found")
        );

        List<GameEventResponse> gameEvent = gameEventService.getGameEvent(gameId).stream().map(
                gameEvent1 -> {
                     return GameEventResponse.builder()
                             .gameEventId(gameEvent1.getId())
                             .minute(gameEvent1.getMinute())
                             .type(gameEvent1.getType())
                             .clubName(gameEvent1.getClubId().getName())
                             .player(gameEvent1.getPlayerId() != null ? playerService.getPlayerByIdAsSimplifiedPlayerResponse(gameEvent1.getPlayerId()) : null)
                             .playerInId(gameEvent1.getPlayerInId() != null ? playerService.getPlayerByIdAsSimplifiedPlayerResponse(gameEvent1.getPlayerInId()) : null)
                             .playerAssistId(gameEvent1.getPlayerAssistId() != null ? playerService.getPlayerByIdAsSimplifiedPlayerResponse(gameEvent1.getPlayerAssistId()) : null)
                            .build();
                }
        ).toList();

        return GameEventMapper.gameEventToGameEventResponse(gameId.toString(), game.getDate(), gameEvent);
    }
}
