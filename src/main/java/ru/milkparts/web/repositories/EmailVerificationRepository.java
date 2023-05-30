package ru.milkparts.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milkparts.web.models.EmailVerification;

@Repository
public interface EmailVerificationRepository extends CrudRepository<EmailVerification, String> {
    boolean existsByUsername(String username);
    EmailVerification findByUsername(String username);
}
