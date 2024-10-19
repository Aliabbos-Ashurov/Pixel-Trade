package com.pdp.PixelTrade.service.client;

import com.pdp.PixelTrade.client.CbuUzClient;
import com.pdp.PixelTrade.dto.client.CbuUzResponseDTO;
import com.pdp.PixelTrade.enums.CurrencyType;
import com.pdp.PixelTrade.exceptions.client.CurrencyRateFetchException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  17:23
 **/
@Service
@RequiredArgsConstructor
public class CbuUzService {

    private final CbuUzClient cbuUzClient;

    public BigDecimal getCurrency(@NotNull CurrencyType type) {
        return getCurrencyRate(() -> cbuUzClient.getCurrency(type));
    }

    public BigDecimal getCurrency(@NotNull CurrencyType type, @NotNull LocalDate date) {
        String datePath = String.format("%d-%02d-%02d", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        return getCurrencyRate(() -> cbuUzClient.getCurrencyByDate(type, datePath));
    }

    private BigDecimal getCurrencyRate(@NotNull Supplier<List<CbuUzResponseDTO>> currencySupplier) {
        return Optional.ofNullable(currencySupplier.get())
                .filter(currencies -> !currencies.isEmpty())
                .map(currencies -> currencies.getFirst().rate())
                .orElseThrow(() -> new CurrencyRateFetchException("Currency Rate Fetch Failed"));
    }
}
