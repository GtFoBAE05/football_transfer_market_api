package org.gtfo.football_transfermarkt_api.dto.mapper.transfer;

import org.gtfo.football_transfermarkt_api.dto.mapper.club.ClubMapper;
import org.gtfo.football_transfermarkt_api.dto.mapper.player.PlayerMapper;
import org.gtfo.football_transfermarkt_api.dto.response.TransferResponse;
import org.gtfo.football_transfermarkt_api.entity.Transfer;

public class TransferMapper {
    public static TransferResponse transferToTransferResponse(Transfer transfer){
        return TransferResponse.builder()
                .player(PlayerMapper.playerToPlayerResponse(transfer.getPlayerId()))
                .transferSeason(transfer.getTransferSeason())
                .transferDate(transfer.getTransferDate())
                .fromClub(ClubMapper.clubToClubResponse(transfer.getFromClub()))
                .toClub(ClubMapper.clubToClubResponse(transfer.getToClub()))
                .transferFee(transfer.getTransferFee())
                .marketValueInEur(transfer.getMarketValueInEur())
                .build();
    }
}
