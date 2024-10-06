package org.gtfo.football_transfermarkt_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "game_events")
public class GameEvent {
    @Id
    @Column(name = "game_event_id", nullable = false)
    private String id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "minute")
    private Integer minute;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club clubId;

    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "description")
    private String description;

    @Column(name = "player_in_id")
    private Integer playerInId;

    @Column(name = "player_assist_id")
    private Integer playerAssistId;
}