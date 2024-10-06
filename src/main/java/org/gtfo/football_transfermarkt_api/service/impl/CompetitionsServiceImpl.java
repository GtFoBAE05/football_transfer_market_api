package org.gtfo.football_transfermarkt_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.gtfo.football_transfermarkt_api.dto.mapper.competition.CompetitionMapper;
import org.gtfo.football_transfermarkt_api.dto.response.CompetitionResponse;
import org.gtfo.football_transfermarkt_api.entity.Competition;
import org.gtfo.football_transfermarkt_api.repository.CompetitionsRepository;
import org.gtfo.football_transfermarkt_api.repository.specification.CompetitionSpecification;
import org.gtfo.football_transfermarkt_api.service.CompetitionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CompetitionsServiceImpl implements CompetitionsService {

    private final CompetitionsRepository competitionsRepository;

    @Override
    public CompetitionResponse getCompetitionById(String competitionId) {
        Competition competition = competitionsRepository.findById(competitionId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource does not exists")
        );


        return CompetitionMapper.competitionToCompetitionResponse(competition);
    }

    @Override
    public Page<CompetitionResponse> getCompetitionsFiltered(Integer page, Integer size,
                                                             String competitionName, String subType, String type,
                                                             String countryName, Boolean isMajorNationalLeague, String sortBy) {

        Specification<Competition> specification = Specification.where(null);

        if (StringUtils.hasText(competitionName)) {
            specification = specification.and(CompetitionSpecification.hasCompetitionName(competitionName));
        }

        if (StringUtils.hasText(subType)) {
            specification = specification.and(CompetitionSpecification.hasSubtype(subType));
        }

        if (StringUtils.hasText(type)) {
            specification = specification.and(CompetitionSpecification.hasType(type));
        }

        if (StringUtils.hasText(countryName)) {
            specification = specification.and(CompetitionSpecification.hasCountryName(countryName));
        }

        if (isMajorNationalLeague != null) {
            specification = specification.and(CompetitionSpecification.isMajorNationalLeague(isMajorNationalLeague));
        }

        if (page>=0){
            page = page-1;
        }
        Pageable pageable = PageRequest.of(page, size);

        Page<CompetitionResponse> competitionResponsePage = competitionsRepository.findAll(
                specification,
                pageable
        ).map(competition -> CompetitionMapper.competitionToCompetitionResponse(competition));

        return competitionResponsePage;
    }

}
