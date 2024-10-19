package com.pdp.PixelTrade.service.wallet;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.entity.wallet.P2PMarket;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.repository.wallet.P2PMarketRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/October/2024  11:21
 **/
@Service
@RequiredArgsConstructor
public class P2PMarketService {
    private final P2PMarketRepository p2PMarketRepository;

    public ApiResponse<List<P2PMarket>> findByOwnerId(@NotNull Long ownerId) {
        return ApiResponse.ok(p2PMarketRepository.findByOwnerId(ownerId));
    }

    public ApiResponse<List<P2PMarket>> findByCryptoType(@NotNull CryptoType cryptoType) {
        return ApiResponse.ok(p2PMarketRepository.findByCryptoType(cryptoType));
    }

    public ApiResponse<List<P2PMarket>> findByCurrencyType(@NotNull CurrencyType currencyType) {
        return ApiResponse.ok(p2PMarketRepository.findByCurrencyType(currencyType));
    }

    public ApiResponse<List<P2PMarket>> findByCryptoAndCurrency(@NotNull CryptoType cryptoType,
                                                                @NotNull CurrencyType currencyType) {
        return ApiResponse.ok(p2PMarketRepository.findByCryptoAndCurrency(cryptoType, currencyType));
    }

    public ApiResponse<List<P2PMarket>> findByDescriptionContaining(@NotNull String keyword) {
        return ApiResponse.ok(p2PMarketRepository.findByDescriptionContaining(keyword));
    }

    public ApiResponse<List<P2PMarket>> findByPriceRange(@NotNull BigDecimal minPrice,
                                                         @NotNull BigDecimal maxPrice) {
        return ApiResponse.ok(p2PMarketRepository.findByPriceRange(minPrice, maxPrice));
    }

    public long countByCryptoType(@NotNull CryptoType cryptoType) {
        return p2PMarketRepository.countByCryptoType(cryptoType);
    }
}
