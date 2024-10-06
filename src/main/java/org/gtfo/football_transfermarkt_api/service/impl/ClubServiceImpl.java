package org.gtfo.football_transfermarkt_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import org.gtfo.football_transfermarkt_api.dto.mapper.club.ClubMapper;
import org.gtfo.football_transfermarkt_api.dto.response.ClubResponse;
import org.gtfo.football_transfermarkt_api.dto.response.GameResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.entity.Club;
import org.gtfo.football_transfermarkt_api.repository.ClubRepository;
import org.gtfo.football_transfermarkt_api.repository.specification.ClubSpecification;
import org.gtfo.football_transfermarkt_api.service.ClubService;
import org.gtfo.football_transfermarkt_api.service.GameService;
import org.gtfo.football_transfermarkt_api.service.PlayerService;
import org.gtfo.football_transfermarkt_api.utils.MultipleParamParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;
    private final GameService gameService;
    private final PlayerService playerService;


    @Override
    public ClubResponse getClubById(Integer clubId) {
        Club club = clubRepository.findById(clubId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club with id " + clubId + " not found")
        );

        return ClubMapper.clubToClubResponse(club);
    }

    @Override
    public Page<ClubResponse> searchClub(Integer page, Integer size, String clubName, List<String> squadSize, List<String> averageAge, String sortBy) {
        Specification<Club> specifications = Specification.where(null);
        List<Sort.Order> orders = new ArrayList<>();

        if (StringUtils.hasText(clubName)) {
            specifications = specifications.and(ClubSpecification.hasName(clubName));
        }

        if (squadSize != null) {
            for (String p : squadSize) {
                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("e")) {
                    specifications = specifications.and(ClubSpecification.hasSquadSizeEqual(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("lt")) {
                    specifications = specifications.and(ClubSpecification.hasSquadSizeLessThan(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("lte")) {
                    specifications = specifications.and(ClubSpecification.hasSquadSizeLessThanEqual(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("gt")) {
                    specifications = specifications.and(ClubSpecification.hasSquadSizeGreaterThan(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("gte")) {
                    specifications = specifications.and(ClubSpecification.hasSquadSizeGreaterThanEqual(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("bte")) {
                    specifications = specifications.and(ClubSpecification.hasSquadSizeBetween(MultipleParamParser.multipleParamIntegerChecker(p).b.a, MultipleParamParser.multipleParamIntegerChecker(p).b.b));
                }
            }
        }

        if (averageAge != null) {
            for (String p : averageAge) {
                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("e")) {
                    specifications = specifications.and(ClubSpecification.hasAverageAgeEqual(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("lt")) {
                    specifications = specifications.and(ClubSpecification.hasAverageAgeLessThan(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("lte")) {
                    specifications = specifications.and(ClubSpecification.hasAverageAgeLessThanEqual(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("gt")) {
                    specifications = specifications.and(ClubSpecification.hasAverageAgeGreaterThan(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("gte")) {
                    specifications = specifications.and(ClubSpecification.hasAverageAgeGreaterThanEqual(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("bte")) {
                    specifications = specifications.and(ClubSpecification.hasAverageAgeBetween(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a, MultipleParamParser.multipleParamBigDecimalChecker(p).b.b));
                }
            }
        }

        if (StringUtils.hasText(sortBy)) {
            List<Pair<String, String>> sortByPairList = MultipleParamParser.sortByParser(sortBy);

            for (Pair<String, String> pair : sortByPairList) {
                if ("asc".equals(pair.a)) {
                    Sort.Order order = new Sort.Order(Sort.Direction.ASC, pair.b);
                    orders.add(order);
                }

                if ("desc".equals(pair.a)) {
                    Sort.Order order = new Sort.Order(Sort.Direction.DESC, pair.b);
                    orders.add(order);
                }
            }

        }

        if (page <= 1) {
            page = page - 1;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(orders));

        return clubRepository.findAll(specifications, pageable).map(
                club -> ClubMapper.clubToClubResponse(club)
        );
    }

    @Override
    public Page<GameResponse> getClubGame(Integer clubId, Integer page, Integer size) {
        clubRepository.findById(clubId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club with id " + clubId + " not found")
        );

        Page<GameResponse> gameResponsePage = gameService.getClubGame(clubId, page, size);

        return gameResponsePage;
    }

    @Override
    public Page<PlayerResponse> getClubPlayer(Integer clubId, Integer page, Integer size, String sortBy) {
        clubRepository.findById(clubId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club with id " + clubId + " not found")
        );

        return playerService.findPlayerWithClubId(clubId, page, size, sortBy);
    }
}
