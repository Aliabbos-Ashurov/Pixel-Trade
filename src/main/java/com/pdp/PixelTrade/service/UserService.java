package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.auth.UserDTO;
import com.pdp.PixelTrade.dto.auth.UserRegisterDTO;
import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.dto.transaction.response.WalletDTO;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.mapper.UserMapper;
import com.pdp.PixelTrade.repository.UserRepository;
import com.pdp.PixelTrade.service.wallet.CryptoAssetService;
import com.pdp.PixelTrade.service.wallet.WalletService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  15:39
 **/
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final WalletService walletService;
    private final CryptoAssetService cryptoAssetService;

    public ApiResponse<UserResponseDTO> findById(@NotNull Long id) {
        return ApiResponse.ok(userMapper.toUserResponseDTO(userRepository.findByIdAndDeletedFalse(id)));
    }

    public UserDTO findByUsername(@NotNull String username) {
        UserDTO dto = userMapper.toUserDTO(userRepository.findByUsername(username));
        if (dto == null)
            throw new UsernameNotFoundException("Username not found with: " + username);
        return dto;
    }


    @Transactional
    public ApiResponse<UserResponseDTO> register(@NotNull UserRegisterDTO dto) {
        User user = userMapper.toUser(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);

        WalletDTO wallet = walletService.createWallet(Wallet.builder()
                .user(user)
                .build());
        cryptoAssetService.createCryptoAsset(wallet.address(), new BigDecimal(10), CryptoType.BTC);

        return ApiResponse.ok(userMapper.toUserResponseDTO(save));
    }
}
