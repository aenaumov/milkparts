package ru.milkparts.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/user/details")

public class UserController {

    @GetMapping
    public ModelAndView userPage(ModelAndView model) {
//TODO logger

        model.setViewName("user_details");
        return model;
    }
}
