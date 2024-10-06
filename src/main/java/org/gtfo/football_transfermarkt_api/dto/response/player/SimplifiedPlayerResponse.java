package org.gtfo.football_transfermarkt_api.dto.response.player;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimplifiedPlayerResponse {
    private Integer id;

    private String name;

    private String imageUrl;

    private String url;
}
