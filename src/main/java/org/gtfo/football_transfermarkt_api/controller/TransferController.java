package org.gtfo.football_transfermarkt_api.controller;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.mapper.template.ResponseMapper;
import org.gtfo.football_transfermarkt_api.dto.response.TransferResponse;
import org.gtfo.football_transfermarkt_api.service.TransferService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/api/transfer"
)
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity getAllTransfer(
            @RequestParam(name = "player", required = false) Integer playerId,
            @RequestParam(name = "fromClub", required = false) Integer fromClubId,
            @RequestParam(name = "toClub", required = false) Integer toClubId,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "sort", required = false, defaultValue = " transferDate") String sortBy
    ) {
        Page<TransferResponse> transferResponsePage = transferService.getAllTransfer(playerId, fromClubId, toClubId, page, size, sortBy);

        return ResponseMapper.paginationMapper(true, HttpStatus.OK, "Success fetch all transfer", transferResponsePage, null);
    }
}
