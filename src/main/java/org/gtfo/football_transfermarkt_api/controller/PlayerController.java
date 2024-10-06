package org.gtfo.football_transfermarkt_api.controller;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.mapper.template.ResponseMapper;
import org.gtfo.football_transfermarkt_api.dto.response.PlayerAppearanceResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/player"
)
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping(
            path = "/{playerId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    private ResponseEntity getPlayerById(@PathVariable Integer playerId) {
        PlayerResponse player = playerService.getPlayerById(playerId);

        return ResponseMapper.basicMapper(true, HttpStatus.OK, "Success fetch player with id " + playerId, player, null);
    }

    @GetMapping(
            path = "/{playerId}/appearance",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    private ResponseEntity getPlayerAppearance(
            @PathVariable Integer playerId,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sort", required = false, defaultValue = " date") String sortBy
    ) {
        Page<PlayerAppearanceResponse> playerAppearanceResponses = playerService.findPlayerAppearance(playerId, page, size, sortBy);

        return ResponseMapper.paginationMapper(true, HttpStatus.OK, "Success fetch apperance for player with id " + playerId, playerAppearanceResponses, null);
    }

    @GetMapping
    @ResponseBody
    private ResponseEntity getAllPlayers(
            @RequestParam(name = "name", required = false) String playerName,
            @RequestParam(name = "position", required = false) List<String> position,
            @RequestParam(name = "foot", required = false) String foot,
            @RequestParam(name = "height", required = false) List<String> height,
            @RequestParam(name = "marketValue", required = false) List<String> marketValue,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sort", required = false) String sortBy
    ) {
        Page<PlayerResponse> allPlayers = playerService.searchPlayer(page, size, playerName, position,
                foot, height, marketValue, sortBy);

        return ResponseMapper.paginationMapper(true, HttpStatus.OK, "success fetch players data", allPlayers, null);
    }



}
