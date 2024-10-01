package org.gtfo.football_transfermarkt_api.dto.mapper;

import org.gtfo.football_transfermarkt_api.dto.pagination.PaginationItems;
import org.gtfo.football_transfermarkt_api.dto.pagination.PaginationResponse;
import org.gtfo.football_transfermarkt_api.dto.template.ApiResponse;
import org.springframework.data.domain.Page;

public class PaginationMapper {

    public static ApiResponse paginationMapper(Page page, String message) {

        ApiResponse<Object> apiResponse = new ApiResponse<>();

        PaginationItems paginationItems = new PaginationItems();
        paginationItems.setCount(page.getNumberOfElements());
        paginationItems.setTotal(page.getTotalElements());
        paginationItems.setPer_page(page.getSize());

        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setPaginationItems(paginationItems);
        paginationResponse.setLast_visible_page(page.getTotalPages());
        paginationResponse.setHas_next_page(page.getNumber() < (page.getTotalPages()-1));
        paginationResponse.setCurrent_page(page.getNumber());

        apiResponse.setSuccess(true);
        apiResponse.setMessage(message);
        apiResponse.setPagination(paginationResponse);
        apiResponse.setData(page.getContent());

        return apiResponse;


    }

}
