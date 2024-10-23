package com.pdp.PixelTrade.service;

import com.pdp.PixelTrade.entity.TwoFactorAuthentication;
import com.pdp.PixelTrade.exceptions.otp.EmailConflictException;
import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

/**
 * @author Aliabbos Ashurov
 * @since 23/October/2024  10:44
 **/
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;
    private final Configuration configuration;
    private final UserService userService;
    private final TwoFactorAuthenticationService twoFactorService;

    @Value("${project.host}")
    private String host;

    @Value("${server.port}")
    private String port;

    @SneakyThrows
    @Override
    public void sendBackupMail(Long userId, String mail) {
        userService.isNotExistMail(mail, () -> new EmailConflictException(
                "The email address {0} is already associated with an existing account. Please use a different email.", mail));

        var mimeMessage = mailSender.createMimeMessage();
        var mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("noreply@pixeltrade.com");
        mimeMessageHelper.setTo(mail);
        mimeMessageHelper.setSubject("Backup Mail Verification!");

        var template = configuration.getTemplate("backup-mail.ftlh");
        var content = FreeMarkerTemplateUtils.processTemplateIntoString(template, Map.of(
                "host", host,
                "port", port,
                "id", userId,
                "mail", mail
        ));
        mimeMessageHelper.setText(content, true);
        mailSender.send(mimeMessage);
    }

    @Override
    @Transactional
    public void verifyBackupMail(Long userId, String mail) {
        var cur = userService.findById(userId);

        twoFactorService.save(TwoFactorAuthentication.builder()
                .backupMail(mail)
                .isBackupEnabled(true)
                .user(cur)
                .build());

        cur.setTwoFactorEnabled(true);
        userService.updateUser(cur);
    }

    @SneakyThrows
    @Override
    public void sendPasswordChanging(String recipient) {
        var mimeMessage = mailSender.createMimeMessage();
        var mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("noreply@pixeltrade.com");
        mimeMessageHelper.setTo(recipient);
        mimeMessageHelper.setSubject("Password Changed!");

        var template = configuration.getTemplate("psw-changed.ftlh");
        var content = FreeMarkerTemplateUtils.processTemplateIntoString(template, Map.of());
        mimeMessageHelper.setText(content, true);
        mailSender.send(mimeMessage);
    }
}
