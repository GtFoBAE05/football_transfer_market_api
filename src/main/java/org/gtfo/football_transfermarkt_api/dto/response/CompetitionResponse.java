package org.gtfo.football_transfermarkt_api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionResponse {
    private String competitionId;

    private String competitionCode;

    private String name;

    private String subType;

    private String type;

    private String countryId;

    private String countryName;

    private String domesticLeagueCode;

    private String confederation;

    private String url;

    private boolean isMajorNationalLeague;
}
