package ru.milkparts.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/{path}")
public class IndexController {

    @GetMapping
    public String indexPage(@PathVariable String path) {

        switch (path) {
            case "index":
                return "index";
            case "delivery":
                return "delivery";
            case "feedback":
                return "feedback";
            default:
                return "404";
        }

    }
}
