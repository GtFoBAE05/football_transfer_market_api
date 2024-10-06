package org.gtfo.football_transfermarkt_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @Column(name = "club_id", nullable = false)
    private Integer id;

    @Column(name = "club_code")
    private String clubCode;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domestic_competition_id")
    private Competition domesticCompetition;

    @Column(name = "total_market_value")
    private String totalMarketValue;

    @Column(name = "squad_size")
    private Integer squadSize;

    @Column(name = "average_age", precision = 3, scale = 1)
    private BigDecimal averageAge;

    @Column(name = "foreigners_number")
    private Integer foreignersNumber;

    @Column(name = "foreigners_percentage", precision = 5, scale = 2)
    private BigDecimal foreignersPercentage;

    @Column(name = "national_team_players")
    private Integer nationalTeamPlayers;

    @Column(name = "stadium_name")
    private String stadiumName;

    @Column(name = "stadium_seats")
    private Integer stadiumSeats;

    @Column(name = "net_transfer_record")
    private String netTransferRecord;

    @Column(name = "coach_name")
    private String coachName;

    @Column(name = "last_season")
    private Integer lastSeason;

    @Column(name = "filename")
    private String filename;

    @Column(name = "url")
    private String url;

}