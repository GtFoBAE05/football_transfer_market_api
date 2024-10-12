package org.gtfo.football_transfermarkt_api.service;

import org.gtfo.football_transfermarkt_api.dto.response.TransferResponse;
import org.springframework.data.domain.Page;

public interface TransferService {
    Page<TransferResponse> getAllTransfer(Integer playerId, Integer fromClubId, Integer toClubId, Integer page, Integer size, String sortBy);
}
