package org.gtfo.football_transfermarkt_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.mapper.playerAppearance.PlayerAppearanceMapper;
import org.gtfo.football_transfermarkt_api.dto.response.PlayerAppearanceResponse;
import org.gtfo.football_transfermarkt_api.repository.PlayerApperearanceRepository;
import org.gtfo.football_transfermarkt_api.service.PlayerAppearanceService;
import org.gtfo.football_transfermarkt_api.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerAppearanceServiceImpl implements PlayerAppearanceService {

    private final PlayerApperearanceRepository playerApperearanceRepository;

    @Override
    public Page<PlayerAppearanceResponse> getPlayerAppearanceByPlayerId(Integer playerId, Integer page, Integer size, String sortBy) {

        List<Sort.Order> orders = new ArrayList<>();

        if (page <= 1) {
            page = page - 1;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(orders));

        return playerApperearanceRepository.findByPlayerId(playerId, pageable).map(
                playerAppearance -> PlayerAppearanceMapper.playerAppearanceToPlayerAppearanceResponse(playerAppearance)
        );
    }
}
