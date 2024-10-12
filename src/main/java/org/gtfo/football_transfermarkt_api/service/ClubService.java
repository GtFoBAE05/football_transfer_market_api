package org.gtfo.football_transfermarkt_api.service;


import org.gtfo.football_transfermarkt_api.dto.response.ClubResponse;
import org.gtfo.football_transfermarkt_api.dto.response.GameResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.entity.Club;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClubService {
    ClubResponse getClubById(Integer clubId);
    Club getClub(Integer clubId);

    Page<ClubResponse> searchClub(
            Integer page, Integer size,String clubName,
            List<String> squadSize, List<String> averageAge, String sortBy
    );

    Page<GameResponse> getClubGame(Integer clubId, Integer Page, Integer size);

    Page<PlayerResponse> getClubPlayer(Integer clubId, Integer page, Integer size, String sortBy);
}
