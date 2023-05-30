package ru.milkparts.web.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.milkparts.web.models.DTOs.UserRegistrationDTO;
import ru.milkparts.web.models.User;

public interface UserService extends UserDetailsService {
    User registerNewUserAccount(UserRegistrationDTO userDto);
    User verifyUser(String username);
}
