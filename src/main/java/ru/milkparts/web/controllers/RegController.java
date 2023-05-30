package ru.milkparts.web.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.milkparts.web.events.UserRegistrationEvent;
import ru.milkparts.web.exceptions.UserAlreadyExistException;
import ru.milkparts.web.models.DTOs.UserRegistrationDTO;
import ru.milkparts.web.models.User;
import ru.milkparts.web.services.UserService;

@Controller
@RequestMapping(path = "/reg")
public class RegController {

    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDTO());
        return "reg";
    }

    @PostMapping
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDTO userRegistrationDTO,
                                      BindingResult result, ModelAndView mav) {

        if (result.hasErrors()) {
            return mav;
        }

        try {
            final User registered = userService.registerNewUserAccount(userRegistrationDTO);

            eventPublisher.publishEvent(new UserRegistrationEvent(registered));

        } catch (UserAlreadyExistException uaeEx) {
            mav.addObject("message", uaeEx.getMessage());
            return mav;
        }

        return new ModelAndView("redirect:login?validate");
    }
}
