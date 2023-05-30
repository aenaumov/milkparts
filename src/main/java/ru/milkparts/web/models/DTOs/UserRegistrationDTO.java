package ru.milkparts.web.models.DTOs;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.milkparts.web.validation.PasswordMatches;
import ru.milkparts.web.validation.ValidEmail;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@PasswordMatches
public class UserRegistrationDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String matchingPassword;
    @ValidEmail
    private String email;
    private Boolean verified = false;
    private String userRole = "USER";

}
