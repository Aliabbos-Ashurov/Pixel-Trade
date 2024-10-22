package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.TransactionCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.TransactionUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.TransactionResponseDTO;
import com.pdp.PixelTrade.entity.wallet.Fee;
import com.pdp.PixelTrade.entity.wallet.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

/**
 * @author Aliabbos Ashurov
 * @since 16/October/2024  15:43
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransactionMapper
        extends GenericMapper<Transaction, TransactionResponseDTO, TransactionCreateDTO, TransactionUpdateDTO> {

    @Mappings({
            @Mapping(target = "fromAddress", source = "dto.fromAddress"),
            @Mapping(target = "toAddress", source = "dto.toAddress"),
            @Mapping(target = "amount", source = "dto.amount"),
            @Mapping(target = "cryptoType", source = "dto.cryptoType"),
            @Mapping(target = "transactionType", source = "dto.transactionType"),
            @Mapping(target = "feeAmount", source = "fee.fee"),
            @Mapping(target = "feePercentage", source = "fee.feePercentage"),
            @Mapping(target = "metadata", ignore = true),
            @Mapping(target = "qrCodeUrl", ignore = true),
            @Mapping(target = "errorMessage", ignore = true),
    })
    TransactionResponseDTO toDTO(TransactionCreateDTO dto, Fee fee);
}
