package org.gtfo.football_transfermarkt_api.controller;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.mapper.template.ResponseMapper;
import org.gtfo.football_transfermarkt_api.dto.response.ClubResponse;
import org.gtfo.football_transfermarkt_api.dto.response.GameResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/club"
)
@RequiredArgsConstructor
public class ClubController {
    private final ClubService clubService;

    @GetMapping(
            path = "/{clubId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    private ResponseEntity getClubById(@PathVariable Integer clubId) {
        ClubResponse clubById = clubService.getClubById(clubId);

        return ResponseMapper.basicMapper(true, HttpStatus.OK, "Success fetch club with id " + clubId, clubById, null);
    }

    @GetMapping(
            path = "/{clubId}/game",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    private ResponseEntity getClubGame(
            @PathVariable Integer clubId,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        Page<GameResponse> gameResponsePage = clubService.getClubGame(clubId, page, size);

        return ResponseMapper.paginationMapper(true, HttpStatus.OK, "Success fetch club game with id " + clubId, gameResponsePage, null);
    }

    @GetMapping(
            path = "/{clubId}/player",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    private ResponseEntity getClubPlayer(
            @PathVariable Integer clubId,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sort", required = false) String sortBy
    ) {
        Page<PlayerResponse> playerResponsePage = clubService.getClubPlayer(clubId, page, size, sortBy);

        return ResponseMapper.paginationMapper(true, HttpStatus.OK, "Success fetch club player with id " + clubId, playerResponsePage, null);
    }

    @GetMapping
    @ResponseBody
    private ResponseEntity getAllCompetitions(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "squadsize", required = false) List<String> squadSize,
            @RequestParam(name = "averageage", required = false) List<String> averageAge,
            @RequestParam(name = "sort", required = false) String sortBy
    ) {
        System.out.println(sortBy);
        Page<ClubResponse> clubResponses = clubService.searchClub(page, size, name, squadSize, averageAge, sortBy);

        return ResponseMapper.paginationMapper(true, HttpStatus.OK, "success fetch club data", clubResponses, null);
    }


}
