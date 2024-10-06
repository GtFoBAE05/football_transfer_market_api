package org.gtfo.football_transfermarkt_api.dto.mapper.club;

import org.gtfo.football_transfermarkt_api.dto.mapper.competition.CompetitionMapper;
import org.gtfo.football_transfermarkt_api.dto.response.ClubResponse;
import org.gtfo.football_transfermarkt_api.entity.Club;

public class ClubMapper {

    public static ClubResponse clubToClubResponse(Club club){
        return ClubResponse.builder()
                .id(club.getId())
                .clubCode(club.getClubCode())
                .domesticCompetition(CompetitionMapper.competitionToCompetitionResponse(club.getDomesticCompetition()))
                .name(club.getName())
                .totalMarketValue(club.getTotalMarketValue())
                .squadSize(club.getSquadSize())
                .averageAge(club.getAverageAge())
                .foreignersNumber(club.getForeignersNumber())
                .foreignersPercentage(club.getForeignersPercentage())
                .nationalTeamPlayers(club.getNationalTeamPlayers())
                .stadiumName(club.getStadiumName())
                .stadiumSeats(club.getStadiumSeats())
                .netTransferRecord(club.getNetTransferRecord())
                .coachName(club.getCoachName())
                .lastSeason(club.getLastSeason())
                .url(club.getUrl())
                .build();
    }

}
