package org.gtfo.football_transfermarkt_api.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponse {
    private Integer last_visible_page;
    private Boolean has_next_page;
    private Integer current_page;
    private PaginationItems paginationItems;
}
