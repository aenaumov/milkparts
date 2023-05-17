package ru.milkparts.web.services;

import ru.milkparts.web.models.DTOs.UserRegistrationDTO;
import ru.milkparts.web.models.User;

public interface UserRegistrationService {
    User registerNewUserAccount(UserRegistrationDTO userDto);
}
