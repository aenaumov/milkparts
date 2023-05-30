package ru.milkparts.web.services;

public interface EmailVerificationService {
    String generateVerification(String username);
    String getVerificationIdByUsername(String username);
    String getUsernameForVerificationId(String verificationId);
}
