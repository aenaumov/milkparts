package ru.milkparts.web.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.milkparts.web.models.DTOs.UserRegistrationDTO;
import ru.milkparts.web.models.User;

public final class UserMapper {

    private UserMapper() {

    }

    public static User toUser(UserRegistrationDTO userRegistrationDTO, PasswordEncoder passwordEncoder) {
        return new User(
                null,
                userRegistrationDTO.getUsername(),
                userRegistrationDTO.getEmail(),
                passwordEncoder.encode(userRegistrationDTO.getPassword()),
                userRegistrationDTO.getVerified(),
                userRegistrationDTO.getUserRole());
    }

}
