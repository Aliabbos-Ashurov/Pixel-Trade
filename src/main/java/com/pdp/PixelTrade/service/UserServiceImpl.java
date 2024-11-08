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
import com.pdp.PixelTrade.eop.event.MailPasswordEvent;
import com.pdp.PixelTrade.exceptions.UserNotFoundException;
import com.pdp.PixelTrade.exceptions.otp.OtpNotFoundException;
import com.pdp.PixelTrade.exceptions.validation.InvalidDataException;
import com.pdp.PixelTrade.mapper.UserMapper;
import com.pdp.PixelTrade.repository.UserRepository;
import com.pdp.PixelTrade.service.otp.OtpService;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;

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
    private final SessionUser sessionUser;
    private final ApplicationEventPublisher eventPublisher;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, PasswordEncoder passwordEncoder, WalletService walletService, CryptoAssetService cryptoAssetService, OtpService otpService, SessionUser sessionUser, ApplicationEventPublisher eventPublisher) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
        this.walletService = walletService;
        this.cryptoAssetService = cryptoAssetService;
        this.otpService = otpService;
        this.sessionUser = sessionUser;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void isNotExistMail(String email, Supplier<RuntimeException> supplier) {
        if (repository.existEmail(email)) throw supplier.get();
    }

    public Response<Boolean> existEmail(String email) {
        return Response.ok(repository.existEmail(email));
    }

    @Override
    public <T> T find(Long id, Class<T> clazz) {
        User user = repository.findById(id).orElse(null);
        assert user != null;
        if (clazz == User.class) return clazz.cast(user);
        else if (clazz == UserResponseDTO.class) return clazz.cast(mapper.toDTO(user));
        else throw new IllegalArgumentException("Unsupported return type: " + clazz.getName());
    }

    @Override
    public Response<UserResponseDTO> findMe() {
        return find(sessionUser.id());
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: {0}", id));
    }

    public User findByUsername(@NotNull String username) {
        User user = repository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("Username not found with: " + username);
        return user;
    }

    @Override
    public Response<UserResponseDTO> create(UserCreateDTO dto) {
        if (!otpService.isOtpUsedByRecipient(dto.email(), OtpType.EMAIL))
            throw new OtpNotFoundException("Otp not used with this recipient: {0}", dto.email());
        User user = mapper.fromCreate(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = repository.save(user);

        WalletResponseDTO wallet = walletService.createWallet(Wallet.builder().user(user).build());
        cryptoAssetService.createCryptoAsset(wallet.address(), new BigDecimal(10), CryptoType.BTC);

        return Response.ok(mapper.toDTO(save));
    }

    @Override
    @Transactional
    public Response<Boolean> update(UserUpdateDTO dto) {
        var cur = repository.findByIdAndDeletedFalse(sessionUser.id());
        if (!passwordEncoder.matches(dto.oldPassword(), cur.getPassword()))
            throw new InvalidDataException("Invalid password or Password does not match");
        cur.setPassword(passwordEncoder.encode(dto.newPassword()));
        repository.save(cur);
        eventPublisher.publishEvent(new MailPasswordEvent(cur.getEmail()));
        return Response.ok(true);
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public Response<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public Response<UserResponseDTO> find(Long id) {
        return Response.ok(mapper.toDTO(repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with: {0}", id))));
    }

    @Override
    public Response<List<UserResponseDTO>> findAll() {
        return Response.ok(repository.findAll().stream().map(mapper::toDTO).toList());
    }
}
