package org.gtfo.football_transfermarkt_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @Column(name = "game_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @Column(name = "season")
    private String season;

    @Column(name = "round")
    private String round;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_club_id")
    private Club homeClub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_club_id")
    private Club awayClub;

    @Column(name = "home_club_goals")
    private Integer homeClubGoals;

    @Column(name = "away_club_goals")
    private Integer awayClubGoals;

    @Column(name = "home_club_position")
    private Integer homeClubPosition;

    @Column(name = "away_club_position")
    private Integer awayClubPosition;

    @Column(name = "home_club_manager_name")
    private String homeClubManagerName;

    @Column(name = "away_club_manager_name")
    private String awayClubManagerName;

    @Column(name = "stadium")
    private String stadium;

    @Column(name = "attendance")
    private Integer attendance;

    @Column(name = "referee")
    private String referee;

    @Column(name = "url")
    private String url;

    @Column(name = "home_club_formation")
    private String homeClubFormation;

    @Column(name = "away_club_formation")
    private String awayClubFormation;

    @Column(name = "home_club_name")
    private String homeClubName;

    @Column(name = "away_club_name")
    private String awayClubName;

    @Column(name = "aggregate")
    private String aggregate;

    @Column(name = "competition_type")
    private String competitionType;
}