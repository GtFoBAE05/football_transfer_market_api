package org.gtfo.football_transfermarkt_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "player_appearances")
public class PlayerAppearance {
    @Id
    @Column(name = "appearance_id")
    private String appearanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_club_id")
    private Club playerClub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_current_club_id")
    private Club playerCurrentClub;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "player_name")
    private String playerName;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @Column(name = "yellow_cards")
    private Integer yellowCards;

    @Column(name = "red_cards")
    private Integer redCards;

    @Column(name = "goals")
    private Integer goals;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "minutes_played")
    private Integer minutesPlayed;

}