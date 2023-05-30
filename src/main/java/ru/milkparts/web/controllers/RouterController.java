package ru.milkparts.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.milkparts.web.models.DTOs.CategoryPageDTO;
import ru.milkparts.web.services.PageService;

@Controller
@RequestMapping(path = "/{path}")

public class RouterController {

    private final PageService pageService;

    public RouterController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public ModelAndView routerPage(@PathVariable String path, ModelAndView model) {

        return switch (path) {
            case "index", "delivery", "feedback", "login" -> getStaticPage(path, model);

            default -> getCategoryPage(path, model);
        };
    }

    private ModelAndView getStaticPage (String path, ModelAndView model){
        model.setViewName(path);
        return model;
    }

    private ModelAndView getCategoryPage (String path, ModelAndView model){

        CategoryPageDTO cat = pageService.getCategoryPage(path);
        model.addObject("cat", cat);
        model.setViewName("category");
        return model;
    }

}
