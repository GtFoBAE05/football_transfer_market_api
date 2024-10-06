package org.gtfo.football_transfermarkt_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "game_lineups")
@NoArgsConstructor
@AllArgsConstructor
public class GameLineup {
    @Id
    @Column(name = "game_lineups_id")
    private String id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "type")
    private String type;

    @Column(name = "position")
    private String position;

    @Column(name = "number")
    private String number;

    @ColumnDefault("false")
    @Column(name = "team_captain")
    private Boolean teamCaptain;
}