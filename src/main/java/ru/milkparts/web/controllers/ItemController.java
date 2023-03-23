package ru.milkparts.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.milkparts.web.DTOs.ItemPageDTO;
import ru.milkparts.web.services.PageService;

@Controller
@RequestMapping(path = "/{category}/{itemId:[-\\w]+}")

public class ItemController {

    private final PageService pageService;

    public ItemController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public ModelAndView itemPage(@PathVariable String itemId, @PathVariable String category, ModelAndView model) {
//TODO logger
        ItemPageDTO item = pageService.getItemPage(itemId, category);

        model.addObject("item", item);
        model.setViewName("item");
        return model;
    }
}
