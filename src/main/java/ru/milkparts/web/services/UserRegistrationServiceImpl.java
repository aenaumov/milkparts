package ru.milkparts.web.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.milkparts.web.exceptions.UserAlreadyExistException;
import ru.milkparts.web.models.DTOs.UserRegistrationDTO;
import ru.milkparts.web.models.User;
import ru.milkparts.web.repositories.UserRepository;

@Service
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUserAccount(UserRegistrationDTO userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        final User user = userDto.toUser(passwordEncoder);
        repository.save(user);
        return user;
    }

    private boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }

}
