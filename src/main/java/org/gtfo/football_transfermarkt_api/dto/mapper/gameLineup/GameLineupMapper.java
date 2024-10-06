package org.gtfo.football_transfermarkt_api.dto.mapper.gameLineup;

import org.gtfo.football_transfermarkt_api.dto.mapper.player.PlayerMapper;
import org.gtfo.football_transfermarkt_api.dto.response.gameLineup.GameLineupClubResponse;
import org.gtfo.football_transfermarkt_api.dto.response.gameLineup.GameLineupPlayerResponse;
import org.gtfo.football_transfermarkt_api.dto.response.gameLineup.GameLineupSeparatedResponse;
import org.gtfo.football_transfermarkt_api.entity.GameLineup;

import java.util.ArrayList;
import java.util.List;

public class GameLineupMapper {
    public static GameLineupPlayerResponse gameLineupToGameLineupPlayerResponse(GameLineup gameLineup){
        return GameLineupPlayerResponse.builder()
                .id(gameLineup.getId())
                .player(PlayerMapper.playerToPlayerResponse(gameLineup.getPlayer()))
                .type(gameLineup.getType())
                .position(gameLineup.getPosition())
                .number(gameLineup.getNumber().trim())
                .teamCaptain(gameLineup.getTeamCaptain())
                .build();


    }

    public static GameLineupClubResponse gameLineupToGameLineupClubResponse(List<GameLineup> gameLineup){

        List<GameLineupPlayerResponse> list = gameLineup.stream().map(
                gameLineup1 -> gameLineupToGameLineupPlayerResponse(gameLineup1)
        ).toList();

        return  GameLineupClubResponse.builder()
                .clubId(gameLineup.get(0).getClub().getId().toString())
                .clubName(gameLineup.get(0).getClub().getName())
                .lineup(list)
                .build();
    }

    public static GameLineupSeparatedResponse gameLineupToGameLineupSeparatedResponse(List<GameLineup> gameLineup){
        String teamAId = gameLineup.get(0).getClub().getId().toString();
        List<GameLineup> teamA = new ArrayList<>();
        List<GameLineup> teamB = new ArrayList<>();

        for (GameLineup lineup : gameLineup) {
            if(teamAId.equals(lineup.getClub().getId().toString())){
                teamA.add(lineup);
            }else{
                teamB.add(lineup);
            }
        }

        return GameLineupSeparatedResponse.builder()
                .date(gameLineup.get(0).getDate())
                .clubA(gameLineupToGameLineupClubResponse(teamA))
                .clubB(gameLineupToGameLineupClubResponse(teamB))
                .build();
    }



}
