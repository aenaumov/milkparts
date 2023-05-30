package ru.milkparts.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.milkparts.web.models.EmailVerification;
import ru.milkparts.web.repositories.EmailVerificationRepository;
import ru.milkparts.web.services.EmailVerificationService;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmailVerificationServiceImpl implements EmailVerificationService {
    @Autowired
    private EmailVerificationRepository repository;

    @Override
    @Transactional
    public String generateVerification(String username) {
        if (!repository.existsByUsername(username)) {
            EmailVerification verification = new EmailVerification(username);
            verification = repository.save(verification);
            return verification.getVerificationId();
        }
        return getVerificationIdByUsername(username);
    }

    @Override
    public String getVerificationIdByUsername(String username) {
        EmailVerification verification = repository.findByUsername(username);
        if (verification != null) {
            return verification.getVerificationId();
        }
        return null;
    }

    @Override
    public String getUsernameForVerificationId(String verificationId) {
        Optional<EmailVerification> verification = repository.findById(verificationId);
        if (verification.isPresent()) {
            return verification.get().getUsername();
        }
        return null;
    }
}
