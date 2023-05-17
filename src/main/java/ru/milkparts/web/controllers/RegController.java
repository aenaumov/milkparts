package ru.milkparts.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.milkparts.web.exceptions.UserAlreadyExistException;
import ru.milkparts.web.models.DTOs.UserRegistrationDTO;
import ru.milkparts.web.models.User;
import ru.milkparts.web.services.UserRegistrationService;

@Controller
@RequestMapping(path = "/reg")
public class RegController {

    private final UserRegistrationService userRegistrationService;

    public RegController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("user", new UserRegistrationDTO());
        return "reg";
    }

    @PostMapping
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDTO userRegistrationDTO,
                                      BindingResult result, HttpServletRequest request, ModelAndView mav) {

        if (result.hasErrors()) {
            return mav;
        }

        try {
            final User registered = userRegistrationService.registerNewUserAccount(userRegistrationDTO);
        } catch (UserAlreadyExistException uaeEx) {
            mav.addObject("message", uaeEx.getMessage());
            return mav;
        }

        return new ModelAndView("login");
    }
}
