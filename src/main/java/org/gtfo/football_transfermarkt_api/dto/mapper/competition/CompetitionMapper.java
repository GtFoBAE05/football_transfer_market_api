package org.gtfo.football_transfermarkt_api.dto.mapper.competition;

import org.gtfo.football_transfermarkt_api.dto.response.CompetitionResponse;
import org.gtfo.football_transfermarkt_api.entity.Competition;

public class CompetitionMapper {

    public static CompetitionResponse competitionToCompetitionResponse(Competition competition) {
        if (competition == null) {
            return null;
        }
        return CompetitionResponse.builder()
                .competitionId(competition.getId())
                .competitionCode(competition.getCompetitionCode())
                .name(competition.getName())
                .subType(competition.getSubType())
                .type(competition.getType())
                .countryId(competition.getCountryId())
                .countryName(competition.getCountryName())
                .domesticLeagueCode(competition.getDomesticLeagueCode())
                .confederation(competition.getConfederation())
                .url(competition.getUrl())
                .isMajorNationalLeague(competition.isMajorNationalLeague())
                .build();
    }


}
