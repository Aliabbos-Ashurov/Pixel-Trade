package com.pdp.PixelTrade.service.otp;

import com.pdp.PixelTrade.dto.ApiResponse;
import com.pdp.PixelTrade.dto.request.OtpSendRequestDTO;
import com.pdp.PixelTrade.dto.request.OtpVerifyRequestDTO;
import com.pdp.PixelTrade.dto.response.OtpResponseDTO;
import com.pdp.PixelTrade.entity.Otp;
import com.pdp.PixelTrade.enums.OtpType;
import com.pdp.PixelTrade.exceptions.otp.OtpExpiredException;
import com.pdp.PixelTrade.exceptions.otp.TooManyOtpRequestsException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
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
    public void send(OtpSendRequestDTO request) {
        if (otpService.hasActiveOtp(request.recipient()))
            throw new TooManyOtpRequestsException("Too many active otp requests with recipient: {0}", request.recipient());

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("noreply@pixeltrade.com");
        mimeMessageHelper.setTo(request.recipient());
        mimeMessageHelper.setSubject("Activation!");

        Template template = configuration.getTemplate("otp.ftlh");
        String code = generateOtpCode();
        Map<String, Object> model = Map.of("code", code);
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        mimeMessageHelper.setText(content, true);

        otpService.save(request.recipient(), code, OtpType.EMAIL);
        mailSender.send(mimeMessage);
    }

    @Override
    public ApiResponse<OtpResponseDTO> verify(OtpVerifyRequestDTO request) {

        Otp activeOtp = otpService.findActiveOtp(request.recipient(), request.code());
        if (activeOtp.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new OtpExpiredException("OTP expired with request code: {0}, recipient: {1}", request.code(), request.recipient());
        }
        otpService.markOtpAsUsed(request.recipient(), request.code());
        return ApiResponse.ok(new OtpResponseDTO(true, "OTP verified successfully"));
    }
}
