package org.gtfo.football_transfermarkt_api.service;

import org.gtfo.football_transfermarkt_api.dto.response.CompetitionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompetitionsService {
    CompetitionResponse getCompetitionById(String competitionId);

    Page<CompetitionResponse> getCompetitionsFiltered(Integer page, Integer size,
                                                    String competitionName, String subType, String type,
                                                    String countryName, Boolean isMajorNationalLeague, String sortBy);
}
