package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.entity.TwoFactorAuthentication;
import com.pdp.PixelTrade.repository.TwoFactorAuthenticationMapper;
import com.pdp.PixelTrade.repository.TwoFactorAuthenticationRepository;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  13:12
 **/
@Service
public class TwoFactorAuthenticationService
        extends AbstractService<TwoFactorAuthenticationRepository, TwoFactorAuthenticationMapper> {

    public TwoFactorAuthenticationService(TwoFactorAuthenticationRepository repository, TwoFactorAuthenticationMapper mapper) {
        super(repository, mapper);
    }

    public TwoFactorAuthentication save(TwoFactorAuthentication twoFactorAuthentication) {
        return repository.save(twoFactorAuthentication);
    }

    public TwoFactorAuthentication update(TwoFactorAuthentication twoFactorAuthentication) {
        return repository.save(twoFactorAuthentication);
    }
}
