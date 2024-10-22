package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.transaction.request.P2PMarketCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.P2PMarketUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.P2PMarketResponseDTO;
import com.pdp.PixelTrade.enums.CryptoType;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  10:34
 **/
public interface P2PMarketService extends GenericCrudService<Long, P2PMarketResponseDTO, P2PMarketCreateDTO, P2PMarketUpdateDTO> {

    Response<List<P2PMarketResponseDTO>> findByOwnerId(@NotNull Long ownerId);

    Response<List<P2PMarketResponseDTO>> findByCryptoType(@NotNull CryptoType cryptoType);
}
