package ru.milkparts.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.milkparts.web.models.DTOs.UserRegistrationDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserRegistrationDTO user = (UserRegistrationDTO) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
