package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.request.TransactionCreateDTO;
import com.pdp.PixelTrade.dto.transaction.response.TransactionResponseDTO;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 21/October/2024  19:08
 **/
public interface TransferService {
    Response<TransactionResponseDTO> transferW2W(@NotNull TransactionCreateDTO request);
}
