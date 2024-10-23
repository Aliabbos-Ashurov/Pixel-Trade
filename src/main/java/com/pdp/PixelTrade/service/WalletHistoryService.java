package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.config.security.SessionUser;
import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.response.WalletHistoryResponseDTO;
import com.pdp.PixelTrade.entity.wallet.WalletHistory;
import com.pdp.PixelTrade.mapper.WalletHistoryMapper;
import com.pdp.PixelTrade.repository.WalletHistoryRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 16/October/2024  19:12
 **/
@Service
public class WalletHistoryService extends AbstractService<WalletHistoryRepository, WalletHistoryMapper> {

    private final SessionUser sessionUser;

    public WalletHistoryService(WalletHistoryRepository repository, WalletHistoryMapper mapper, SessionUser sessionUser) {
        super(repository, mapper);
        this.sessionUser = sessionUser;
    }

    public WalletHistory save(@NotNull WalletHistory walletHistory) {
        return repository.save(walletHistory);
    }

    public Response<List<WalletHistoryResponseDTO>> getMe() {
        return Response.ok(
                repository.findByUserId(sessionUser.id()).stream()
                        .map(mapper::toDTO)
                        .toList());
    }

    public Response<List<WalletHistoryResponseDTO>> findAll() {
        return Response.ok(
                repository.findAllDtos().stream()
                        .map(mapper::toDTO)
                        .toList());
    }

    public Response<List<WalletHistoryResponseDTO>> findByWalletId(@NotNull Long walletId) {
        return Response.ok(
                repository.findByWalletId(walletId).stream()
                        .map(mapper::toDTO)
                        .toList());
    }

    public Response<List<WalletHistoryResponseDTO>> findByWalletAddress(@NotNull String address) {
        return Response.ok(
                repository.findByWalletAddress(address).stream()
                        .map(mapper::toDTO)
                        .toList());
    }
}


