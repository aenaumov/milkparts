package ru.milkparts.web.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.milkparts.web.events.UserRegistrationEvent;
import ru.milkparts.web.models.User;
import ru.milkparts.web.services.impl.EmailVerificationServiceImpl;

import java.util.Base64;
import java.util.UUID;

@Slf4j
@Service
public class EmailVerificationListener implements ApplicationListener<UserRegistrationEvent> {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailVerificationServiceImpl verificationService;
    @Autowired
    private Environment env;

    @Override
    public void onApplicationEvent(UserRegistrationEvent event) {
        this.verifyEmail(event);
    }

    private void verifyEmail(final UserRegistrationEvent event) {
        final User user = event.getUser();

//        final String token = UUID.randomUUID().toString();

        final String username = user.getUsername();
        final String verificationId = verificationService.generateVerification(username);

        final SimpleMailMessage message = createEmail(user, verificationId);

        try {
            mailSender.send(message);
        } catch (MailException ex) {
            log.error(ex.getMessage());
        }
    }

    private SimpleMailMessage createEmail(final User user, final String verificationId) {
        final String email = user.getEmail();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Milkparts Account Verification");
        message.setText(getText(user, verificationId));
        message.setFrom(env.getProperty("support.email"));
        message.setTo(email);
        return message;
    }

    private String getText(User user, String verificationId) {
        String encodedVerificationId = new String(Base64.getEncoder().encode(verificationId.getBytes()));
        StringBuffer buffer = new StringBuffer();
        buffer.append("Dear ").append(user.getUsername()).append(",").append(System.lineSeparator());
        buffer.append("Your account has been successfully created in the Milkparts website. ");
        buffer.append("Activate your account by clicking the following link: http://localhost:8080/verify/email?id=")
                .append(encodedVerificationId);
        buffer.append(System.lineSeparator()).append(System.lineSeparator());
        buffer.append("Regards,").append(System.lineSeparator()).append("Milkparts Team");
        return buffer.toString();
    }
}
