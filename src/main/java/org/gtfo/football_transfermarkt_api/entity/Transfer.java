package org.gtfo.football_transfermarkt_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player playerId;

    @Temporal(TemporalType.DATE)
    @Column(name = "transfer_date")
    private LocalDate transferDate;

    @Column(name = "transfer_season", length = Integer.MAX_VALUE)
    private String transferSeason;

    @ManyToOne
    @JoinColumn(name = "from_club_id")
    private Club fromClub;

    @ManyToOne
    @JoinColumn(name = "to_club_id")
    private Club toClub;

    @Column(name = "from_club_name", length = Integer.MAX_VALUE)
    private String fromClubName;

    @Column(name = "to_club_name", length = Integer.MAX_VALUE)
    private String toClubName;

    @Column(name = "transfer_fee")
    private Integer transferFee;

    @Column(name = "market_value_in_eur")
    private Integer marketValueInEur;

    @Column(name = "player_name", length = Integer.MAX_VALUE)
    private String playerName;
}