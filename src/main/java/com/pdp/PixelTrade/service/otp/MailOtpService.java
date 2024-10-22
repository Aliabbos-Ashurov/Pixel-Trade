package com.pdp.PixelTrade.service.otp;

import com.pdp.PixelTrade.dto.Response;
import com.pdp.PixelTrade.dto.auth.OtpResponseDTO;
import com.pdp.PixelTrade.dto.auth.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.auth.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.enums.OtpType;
import com.pdp.PixelTrade.exceptions.otp.OtpExpiredException;
import com.pdp.PixelTrade.exceptions.otp.TooManyOtpRequestsException;
import freemarker.template.Configuration;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Aliabbos Ashurov
 * @since 05/October/2024  19:20
 **/
@Service
@RequiredArgsConstructor
public class MailOtpService implements OtpVerificationService {

    private final OtpService otpService;
    private final JavaMailSender mailSender;
    private final Configuration configuration;

    @SneakyThrows
    @Override
    public void send(@NotNull OtpSendRequestDTO request) {
        if (otpService.hasActiveOtp(request.recipient()))
            throw new TooManyOtpRequestsException("Too many active otp requests with recipient: {0}", request.recipient());

        var mimeMessage = mailSender.createMimeMessage();
        var mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("noreply@pixeltrade.com");
        mimeMessageHelper.setTo(request.recipient());
        mimeMessageHelper.setSubject("Activation!");

        var template = configuration.getTemplate("otp.ftlh");
        var code = generateOtpCode();
        Map<String, Object> model = Map.of("code", code);
        var content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        mimeMessageHelper.setText(content, true);

        otpService.save(request.recipient(), code, OtpType.EMAIL);
        mailSender.send(mimeMessage);
    }

    @Override
    public Response<OtpResponseDTO> verify(@NotNull OtpVerifyRequestDTO request) {
        var activeOtp = otpService.findActiveOtp(request.recipient(), request.code());
        if (activeOtp.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new OtpExpiredException("OTP expired with request code: {0}, recipient: {1}", request.code(), request.recipient());
        }
        otpService.markOtpAsUsed(request.recipient(), request.code());
        return Response.ok(new OtpResponseDTO(true, "OTP verified successfully"));
    }
}
