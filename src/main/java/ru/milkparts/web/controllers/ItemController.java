package ru.milkparts.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.milkparts.web.models.Item;
import ru.milkparts.web.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/category/{itemId}")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public ModelAndView itemPage(@PathVariable String itemId, ModelAndView model) {

        Optional<Item> item = itemRepository.findItemByItemId(itemId);

        List<Item> items = itemRepository.findAll();

        model.addObject("item", item.get());
        model.setViewName("item");
        return model;
    }
}
