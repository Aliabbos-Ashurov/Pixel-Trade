package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.entity.wallet.WalletSuspicionRecord;
import com.pdp.PixelTrade.mapper.WalletSuspicionRecordMapper;
import com.pdp.PixelTrade.repository.WalletSuspicionRecordRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  10:07
 **/
@Service
public class WalletSuspicionRecordService extends AbstractService<WalletSuspicionRecordRepository, WalletSuspicionRecordMapper> {

    public WalletSuspicionRecordService(WalletSuspicionRecordRepository repository, WalletSuspicionRecordMapper mapper) {
        super(repository, mapper);
    }

    public boolean exists(@NotNull String address) {
        return repository.exists(address);
    }

    public Response<List<WalletSuspicionRecord>> findByWalletAddress(@NotNull String address) {
        return Response.ok(repository.findByWalletAddress(address));
    }

    public Response<List<WalletSuspicionRecord>> findByReasonContaining(@NotNull String reason) {
        return Response.ok(repository.findByReasonContaining(reason));
    }

    public Response<List<WalletSuspicionRecord>> findByCreatedAtRange(
            @NotNull LocalDateTime startDate,
            @NotNull LocalDateTime endDate) {
        return Response.ok(repository.findByCreatedAtRange(startDate, endDate));
    }

    public long countSuspectRecordsByWallet(@NotNull String address) {
        return repository.countSuspectRecordsByWallet(address);
    }
}
