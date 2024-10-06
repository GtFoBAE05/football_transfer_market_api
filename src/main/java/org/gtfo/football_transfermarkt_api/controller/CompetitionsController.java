package org.gtfo.football_transfermarkt_api.controller;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.mapper.template.ResponseMapper;
import org.gtfo.football_transfermarkt_api.dto.response.CompetitionResponse;
import org.gtfo.football_transfermarkt_api.service.CompetitionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/api/competitions"
)
@RequiredArgsConstructor
public class CompetitionsController {

    private final CompetitionsService competitionsService;

    @GetMapping(
            path = "/{competitionId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    private ResponseEntity getCompetitionById(@PathVariable String competitionId) {
        CompetitionResponse competition = competitionsService.getCompetitionById(competitionId);

        return ResponseMapper.basicMapper(true, HttpStatus.OK, "Success fetch competition with id " + competitionId, competition, null);
    }

    @GetMapping
    @ResponseBody
    private ResponseEntity getAllCompetitions(
            @RequestParam(name = "name", required = false) String competitionName,
            @RequestParam(name = "subtype", required = false) String subtype,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "countryname", required = false) String countryName,
            @RequestParam(name = "ismajornationalleague", required = false) Boolean isMajorNationalLeague,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sort", required = false) String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CompetitionResponse> allCompetitions = competitionsService.getCompetitionsFiltered(page, size, competitionName, subtype,
                type, countryName, isMajorNationalLeague, sortBy);

        return ResponseMapper.paginationMapper(true, HttpStatus.OK, "success fetch competitions data", allCompetitions, null);
    }

}
