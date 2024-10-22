package com.pdp.PixelTrade.mapper;

import com.pdp.PixelTrade.dto.transaction.request.WalletSuspicionRecordCreateDTO;
import com.pdp.PixelTrade.dto.transaction.request.WalletSuspicionRecordUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.WalletSuspicionRecordResponseDTO;
import com.pdp.PixelTrade.entity.wallet.WalletSuspicionRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 22/October/2024  12:17
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WalletSuspicionRecordMapper
        extends GenericMapper<WalletSuspicionRecord, WalletSuspicionRecordResponseDTO, WalletSuspicionRecordCreateDTO, WalletSuspicionRecordUpdateDTO> {
}
