package org.gtfo.football_transfermarkt_api.dto.mapper.template;

import org.gtfo.football_transfermarkt_api.dto.template.ApiResponse;
import org.gtfo.football_transfermarkt_api.dto.template.pagination.PaginationItems;
import org.gtfo.football_transfermarkt_api.dto.template.pagination.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseMapper {

    public static <T> ResponseEntity<ApiResponse> basicMapper(Boolean status, HttpStatus httpStatus, String message, T data, String error_code) {
        return ResponseEntity.status(httpStatus).body(
                ApiResponse.builder()
                        .success(status)
                        .httpStatus(httpStatus)
                        .message(message)
                        .data(data)
                        .pagination(null)
                        .error_code(error_code)
                        .build()
        );
    }

    public static ResponseEntity<ApiResponse> paginationMapper(Boolean status, HttpStatus httpStatus, String message, Page page, String error_code) {
        PaginationResponse paginationResponse = paginationResponseMapper(page);

        return ResponseEntity.status(httpStatus).body(
                ApiResponse.builder()
                        .success(status)
                        .httpStatus(httpStatus)
                        .message(message)
                        .data(page.getContent())
                        .pagination(paginationResponse)
                        .error_code(error_code)
                        .build()
        );
    }

    private static PaginationResponse paginationResponseMapper(Page page) {
        PaginationItems paginationItems = PaginationItems.builder()
                .count(page.getNumberOfElements())
                .total(page.getTotalElements())
                .per_page(page.getSize())
                .build();

        return PaginationResponse.builder()
                .paginationItems(paginationItems)
                .last_visible_page(page.getTotalPages()-1)
                .has_next_page(page.getNumber() < (page.getTotalPages() - 1))
                .current_page(page.getNumber())
                .build();
    }

}
