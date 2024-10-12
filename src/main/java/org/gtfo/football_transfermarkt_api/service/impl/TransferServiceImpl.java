package org.gtfo.football_transfermarkt_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import org.gtfo.football_transfermarkt_api.dto.mapper.transfer.TransferMapper;
import org.gtfo.football_transfermarkt_api.dto.response.TransferResponse;
import org.gtfo.football_transfermarkt_api.entity.Club;
import org.gtfo.football_transfermarkt_api.entity.Player;
import org.gtfo.football_transfermarkt_api.entity.Transfer;
import org.gtfo.football_transfermarkt_api.repository.TransferRepository;
import org.gtfo.football_transfermarkt_api.repository.specification.TransferSpecification;
import org.gtfo.football_transfermarkt_api.service.ClubService;
import org.gtfo.football_transfermarkt_api.service.PlayerService;
import org.gtfo.football_transfermarkt_api.service.TransferService;
import org.gtfo.football_transfermarkt_api.utils.MultipleParamParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final PlayerService playerService;
    private final ClubService clubService;

    @Override
    public Page<TransferResponse> getAllTransfer(Integer playerId, Integer fromClubId, Integer toClubId, Integer page, Integer size, String sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        Specification<Transfer> specification = Specification.where(null);

        if (playerId != null) {
            Player player = playerService.getPlayer(playerId);
            specification = specification.and(TransferSpecification.playerIdSpecification(player));
        }

        if (fromClubId != null) {
            Club club = clubService.getClub(fromClubId);
            specification = specification.and(TransferSpecification.fromClubIdSpecification(club));
        }

        if (toClubId != null) {
            Club club = clubService.getClub(toClubId);
            specification = specification.and(TransferSpecification.toClubIdSpecification(club));
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
        return transferRepository.findAll(specification, pageable).map(
                transfer -> TransferMapper.transferToTransferResponse(transfer)
        );
    }
}
