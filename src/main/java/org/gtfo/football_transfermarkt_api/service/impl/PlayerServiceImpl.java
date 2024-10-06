package org.gtfo.football_transfermarkt_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import org.gtfo.football_transfermarkt_api.dto.mapper.player.PlayerMapper;
import org.gtfo.football_transfermarkt_api.dto.response.PlayerAppearanceResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.PlayerResponse;
import org.gtfo.football_transfermarkt_api.dto.response.player.SimplifiedPlayerResponse;
import org.gtfo.football_transfermarkt_api.entity.Player;
import org.gtfo.football_transfermarkt_api.repository.PlayerRepository;
import org.gtfo.football_transfermarkt_api.repository.specification.PlayerSpecification;
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
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final PlayerAppearanceServiceImpl playerAppearanceService;

    @Override
    public PlayerResponse getPlayerById(Integer playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource does not exists")
        );
        return PlayerMapper.playerToPlayerResponse(player);
    }

    @Override
    public SimplifiedPlayerResponse getPlayerByIdAsSimplifiedPlayerResponse(Integer playerId) {
        Player player = playerRepository.findById(playerId).orElse(
                null
        );
        return PlayerMapper.playerToSimplifiedPlayerResponse(player);
    }

    @Override
    public Page<PlayerResponse> searchPlayer(Integer page, Integer size, String name, List<String> position, String foot, List<String> height, List<String> marketValue, String sortBy) {
        Specification<Player> specifications = Specification.where(null);
        List<Sort.Order> orders = new ArrayList<>();

        if (StringUtils.hasText(name)) {
            specifications = specifications.and(PlayerSpecification.hasName(name));
        }

        if (position != null) {
            for (String s : position) {
                specifications = specifications.and(PlayerSpecification.hasPosition(s));
            }
        }

        if (StringUtils.hasText(foot)) {
            specifications = specifications.and(PlayerSpecification.hasFoot(foot));
        }

        if (height != null) {
            for (String p : height) {
                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("e")) {
                    specifications = specifications.and(PlayerSpecification.hasHeightEqual(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("lt")) {
                    specifications = specifications.and(PlayerSpecification.hasHeightLessThan(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("lte")) {
                    specifications = specifications.and(PlayerSpecification.hasHeightLessThanEqual(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("gt")) {
                    specifications = specifications.and(PlayerSpecification.hasHeightGreaterThan(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("gte")) {
                    specifications = specifications.and(PlayerSpecification.hasHeightGreaterThanEqual(MultipleParamParser.multipleParamIntegerChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamIntegerChecker(p).a.equals("bte")) {
                    specifications = specifications.and(PlayerSpecification.hasHeightBetween(MultipleParamParser.multipleParamIntegerChecker(p).b.a, MultipleParamParser.multipleParamIntegerChecker(p).b.b));
                }
            }
        }

        if (marketValue != null) {
            for (String p : marketValue) {
                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("e")) {
                    specifications = specifications.and(PlayerSpecification.hasMarketValueEqual(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("lt")) {
                    specifications = specifications.and(PlayerSpecification.hasMarketValueLessThan(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("lte")) {
                    specifications = specifications.and(PlayerSpecification.hasMarketValueLessThanEqual(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("gt")) {
                    specifications = specifications.and(PlayerSpecification.hasMarketValueGreaterThan(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("gte")) {
                    specifications = specifications.and(PlayerSpecification.hasMarketValueGreaterThanEqual(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a));
                }

                if (MultipleParamParser.multipleParamBigDecimalChecker(p).a.equals("bte")) {
                    specifications = specifications.and(PlayerSpecification.hasMarketValueBetween(MultipleParamParser.multipleParamBigDecimalChecker(p).b.a, MultipleParamParser.multipleParamBigDecimalChecker(p).b.b));
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


        return playerRepository.findAll(specifications, pageable).map(
                player -> PlayerMapper.playerToPlayerResponse(player)
        );
    }

    @Override
    public Page<PlayerResponse> findPlayerWithClubId(Integer clubId, Integer page, Integer size, String  sortBy) {
        List<Sort.Order> orders = new ArrayList<>();

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

        return playerRepository.findByCurrentClubId(clubId, pageable).map(
                player -> PlayerMapper.playerToPlayerResponse(player)
        );
    }

    public Page<PlayerAppearanceResponse> findPlayerAppearance(Integer playerId, Integer page, Integer size, String sortBy){
        getPlayerById(playerId);

        return playerAppearanceService.getPlayerAppearanceByPlayerId(playerId, page, size, sortBy);
    }
}
