package org.gtfo.football_transfermarkt_api.dto.mapper.game;

import org.gtfo.football_transfermarkt_api.dto.mapper.club.ClubMapper;
import org.gtfo.football_transfermarkt_api.dto.mapper.competition.CompetitionMapper;
import org.gtfo.football_transfermarkt_api.dto.response.GameResponse;
import org.gtfo.football_transfermarkt_api.entity.Game;

public class GameMapper {
    public static GameResponse gameToGameResponse(Game game) {
        return GameResponse.builder()
                .id(game.getId())
                .competition(CompetitionMapper.competitionToCompetitionResponse(game.getCompetition()))
                .season(game.getSeason())
                .round(game.getRound())
                .date(game.getDate())
                .homeClub(ClubMapper.clubToClubResponse(game.getHomeClub()))
                .awayClub(ClubMapper.clubToClubResponse(game.getAwayClub()))
                .homeClubGoals(game.getHomeClubGoals())
                .awayClubGoals(game.getAwayClubGoals())
                .homeClubPosition(game.getHomeClubPosition())
                .awayClubPosition(game.getAwayClubPosition())
                .homeClubManagerName(game.getHomeClubManagerName())
                .awayClubManagerName(game.getAwayClubManagerName())
                .stadium(game.getStadium())
                .attendance(game.getAttendance())
                .referee(game.getReferee())
                .url(game.getUrl())
                .homeClubFormation(game.getHomeClubFormation())
                .awayClubFormation(game.getAwayClubFormation())
                .homeClubName(game.getHomeClubName())
                .awayClubName(game.getAwayClubName())
                .aggregate(game.getAggregate())
                .competitionType(game.getCompetitionType())
                .build();
    }
}
