package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.config.security.SessionUser;
import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.UserCreateDTO;
import com.pdp.PixelTrade.dto.auth.UserResponseDTO;
import com.pdp.PixelTrade.dto.auth.UserUpdateDTO;
import com.pdp.PixelTrade.dto.transaction.response.WalletResponseDTO;
import com.pdp.PixelTrade.entity.User;
import com.pdp.PixelTrade.entity.wallet.Wallet;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.enums.OtpType;
import com.pdp.PixelTrade.exceptions.UserNotFoundException;
import com.pdp.PixelTrade.exceptions.otp.OtpNotFoundException;
import com.pdp.PixelTrade.mapper.UserMapper;
import com.pdp.PixelTrade.repository.UserRepository;
import com.pdp.PixelTrade.service.otp.OtpService;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  15:39
 **/
@Service
public class UserServiceImpl extends AbstractService<UserRepository, UserMapper> implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final WalletService walletService;
    private final CryptoAssetService cryptoAssetService;
    private final OtpService otpService;

    public UserServiceImpl(UserRepository repository, UserMapper mapper,
                           PasswordEncoder passwordEncoder,
                           WalletService walletService,
                           CryptoAssetService cryptoAssetService,
                           OtpService otpService,
                           SessionUser sessionUser) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
        this.walletService = walletService;
        this.cryptoAssetService = cryptoAssetService;
        this.otpService = otpService;
    }

    public User findByUsername(@NotNull String username) {
        User user = repository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Username not found with: " + username);
        return user;
    }

    @Override
    public Response<UserResponseDTO> create(UserCreateDTO dto) {
        if (!otpService.isOtpUsedByRecipient(dto.email(), OtpType.EMAIL))
            throw new OtpNotFoundException("Otp not used with this recipient: {0}", dto.email());
        User user = mapper.fromCreate(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = repository.save(user);

        WalletResponseDTO wallet = walletService.createWallet(Wallet.builder()
                .user(user)
                .build());
        cryptoAssetService.createCryptoAsset(wallet.address(), new BigDecimal(10), CryptoType.BTC);

        return Response.ok(mapper.toDTO(save));
    }

    @Override
    public Response<Boolean> update(UserUpdateDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public Response<UserResponseDTO> find(Long id) {
        return Response.ok(
                mapper.toDTO(repository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found with: {0}", id))));
    }

    @Override
    public Response<List<UserResponseDTO>> findAll() {
        return Response.ok(repository.findAll().stream()
                .map(mapper::toDTO).toList());
    }
}
