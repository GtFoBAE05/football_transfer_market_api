package org.gtfo.football_transfermarkt_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "competitions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Competition {
    @Id
    @Column(name = "competition_id")
    private String id;

    @Column(name = "competition_code")
    private String competitionCode;

    @Column(name = "name")
    private String name;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "type")
    private String type;

    @Column(name = "country_id")
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "domestic_league_code")
    private String domesticLeagueCode;

    @Column(name = "confederation")
    private String confederation;

    @Column(name = "url")
    private String url;

    @Column(name = "is_major_national_league")
    private boolean isMajorNationalLeague;
}
