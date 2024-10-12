package org.gtfo.football_transfermarkt_api.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.entity.Club;
import org.gtfo.football_transfermarkt_api.entity.Player;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferResponse {
    private PlayerResponse player;

    private LocalDate transferDate;

    private String transferSeason;

    private ClubResponse fromClub;

    private ClubResponse toClub;

    private Integer transferFee;

    private Integer marketValueInEur;


}
