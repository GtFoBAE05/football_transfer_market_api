package org.gtfo.football_transfermarkt_api.dto.template;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.pagination.PaginationResponse;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private PaginationResponse pagination;
    private String error_code;
}
