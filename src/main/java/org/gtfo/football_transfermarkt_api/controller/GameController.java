package org.gtfo.football_transfermarkt_api.controller;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.mapper.template.ResponseMapper;
import org.gtfo.football_transfermarkt_api.dto.response.gameEvent.MappedGameEventResponse;
import org.gtfo.football_transfermarkt_api.dto.response.gameLineup.GameLineupSeparatedResponse;
import org.gtfo.football_transfermarkt_api.service.impl.GameServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/api/game"
)
@RequiredArgsConstructor
public class GameController {

    private final GameServiceImpl gameService;

    @GetMapping(
            path = "/{gameId}/lineup",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    private ResponseEntity getGameLineUpById(
            @PathVariable Integer gameId

    ) {
        GameLineupSeparatedResponse gameLineup = gameService.getGameLineup(gameId);

        return ResponseMapper.basicMapper(true, HttpStatus.OK, "Success fetch game lineup with id " + gameId, gameLineup, null);
    }

    @GetMapping(
            path = "/{gameId}/event",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    private ResponseEntity getGameEvent(
            @PathVariable Integer gameId

    ) {
        MappedGameEventResponse gameEvent = gameService.getGameEvent(gameId);

        return ResponseMapper.basicMapper(true, HttpStatus.OK, "Success fetch game lineup with id " + gameId, gameEvent, null);
    }

}
