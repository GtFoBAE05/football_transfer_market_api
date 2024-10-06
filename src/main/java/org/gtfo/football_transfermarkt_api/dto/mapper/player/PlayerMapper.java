package org.gtfo.football_transfermarkt_api.dto.mapper.player;

import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.SimplifiedPlayerResponse;
import org.gtfo.football_transfermarkt_api.entity.Player;

public class PlayerMapper {
    public static PlayerResponse playerToPlayerResponse(Player player) {
        return PlayerResponse.builder()
                .id(player.getId())
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .name(player.getName())
                .lastSeason(player.getLastSeason())
                .currentClubId(player.getCurrentClubId())
                .playerCode(player.getPlayerCode())
                .countryOfBirth(player.getCountryOfBirth())
                .cityOfBirth(player.getCityOfBirth())
                .countryOfCitizenship(player.getCountryOfCitizenship())
                .dateOfBirth(player.getDateOfBirth())
                .subPosition(player.getSubPosition())
                .position(player.getPosition())
                .foot(player.getFoot())
                .heightInCm(player.getHeight())
                .contractExpirationDate(player.getContractExpirationDate())
                .agentName(player.getAgentName())
                .imageUrl(player.getImageUrl())
                .url(player.getUrl())
                .currentClubDomesticCompetitionId(player.getCurrentClubDomesticCompetitionId())
                .currentClubName(player.getCurrentClubName())
                .marketValueInEur(player.getMarketValueInEur())
                .highestMarketValueInEur(player.getHighestMarketValueInEur())
                .build();
    }

    public static SimplifiedPlayerResponse playerToSimplifiedPlayerResponse(Player player){
        return SimplifiedPlayerResponse.builder()
                .id(player.getId())
                .name(player.getName())
                .imageUrl(player.getImageUrl())
                .url(player.getUrl())
                .build();
    }

}
