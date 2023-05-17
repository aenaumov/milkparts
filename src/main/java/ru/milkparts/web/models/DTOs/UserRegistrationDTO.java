package ru.milkparts.web.models.DTOs;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.milkparts.web.models.User;
import ru.milkparts.web.validation.PasswordMatches;
import ru.milkparts.web.validation.ValidEmail;

@Setter
@Getter
@RequiredArgsConstructor
@PasswordMatches
public class UserRegistrationDTO {

    @NotEmpty(message = "Enter username")
    private String username;
    @NotEmpty(message = "Enter password")
    private String password;
    @NotEmpty(message = "Confirm password")
    private String matchingPassword;
    @ValidEmail
    private String email;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(null, username, email, passwordEncoder.encode(password));
    }
}
