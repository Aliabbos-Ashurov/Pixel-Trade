package com.pdp.PixelTrade.service.client;

import com.pdp.PixelTrade.client.EskizClient;
import com.pdp.PixelTrade.dto.client.EskizBalanceDTO;
import com.pdp.PixelTrade.dto.client.EskizTokenRequestDTO;
import com.pdp.PixelTrade.dto.client.EskizTokenResponseDTO;
import com.pdp.PixelTrade.dto.client.MessageRequestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 08/October/2024  16:27
 **/
@Service
@RequiredArgsConstructor
public class EskizService {

    @Value("${eskiz.token}")
    private String TOKEN;

    @Value("${eskiz.secret-key}")
    private String SECRET_KEY;

    @Value("${eskiz.login.email}")
    private String LOGIN_EMAIL;

    private final EskizClient eskizClient;

    public void sendMessage(@NotNull MessageRequestDTO dto) {
        eskizClient.sendSms("Bearer " + TOKEN, dto);
    }

    public EskizBalanceDTO getEskizBalance() {
        return eskizClient.getEskizBalance("Bearer " + TOKEN);
    }

    public EskizTokenResponseDTO getToken() {
        return eskizClient.getToken(new EskizTokenRequestDTO(LOGIN_EMAIL, SECRET_KEY));
    }

//    public EskizTokenResponseDTO refreshToken() {
//        return eskizClient.refreshToken("Bearer " + TOKEN);
//    }
}
