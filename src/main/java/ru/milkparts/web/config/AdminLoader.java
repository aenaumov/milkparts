package ru.milkparts.web.config;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.milkparts.web.models.DTOs.UserRegistrationDTO;
import ru.milkparts.web.services.UserService;

@Component
public class AdminLoader implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        UserRegistrationDTO adminDTO = new UserRegistrationDTO(
                "admin",
                "admin",
                "admin",
                "admin@test.ru",
                true,
                "ADMIN"
        );

        userService.registerNewUserAccount(adminDTO);
        }
}
