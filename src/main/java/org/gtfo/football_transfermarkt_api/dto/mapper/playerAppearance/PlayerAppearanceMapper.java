package org.gtfo.football_transfermarkt_api.dto.mapper.playerAppearance;

import org.gtfo.football_transfermarkt_api.dto.mapper.club.ClubMapper;
import org.gtfo.football_transfermarkt_api.dto.mapper.competition.CompetitionMapper;
import org.gtfo.football_transfermarkt_api.dto.mapper.game.GameMapper;
import org.gtfo.football_transfermarkt_api.dto.response.PlayerAppearanceResponse;
import org.gtfo.football_transfermarkt_api.entity.PlayerAppearance;

public class PlayerAppearanceMapper {

    public static PlayerAppearanceResponse playerAppearanceToPlayerAppearanceResponse(PlayerAppearance playerAppearance){
        return PlayerAppearanceResponse.builder()
                .appearanceId(playerAppearance.getAppearanceId())
                .game(GameMapper.gameToGameResponse(playerAppearance.getGame()))
                .playerClub(ClubMapper.clubToClubResponse(playerAppearance.getPlayerClub()))
                .playerClub(ClubMapper.clubToClubResponse(playerAppearance.getPlayerCurrentClub()))
                .date(playerAppearance.getDate())
                .playerName(playerAppearance.getPlayerName())
                .competition(CompetitionMapper.competitionToCompetitionResponse(playerAppearance.getCompetition()))
                .yellowCards(playerAppearance.getYellowCards())
                .redCards(playerAppearance.getRedCards())
                .goals(playerAppearance.getGoals())
                .assists(playerAppearance.getAssists())
                .minutesPlayed(playerAppearance.getMinutesPlayed())
                .build();
    }

}
