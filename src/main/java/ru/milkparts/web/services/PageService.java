package ru.milkparts.web.services;

import org.springframework.stereotype.Service;
import ru.milkparts.web.DTOs.ItemPageDTO;
import ru.milkparts.web.exceptions.NotFoundException;
import ru.milkparts.web.models.Category;
import ru.milkparts.web.models.Item;
import ru.milkparts.web.repositories.CategoryRepository;
import ru.milkparts.web.repositories.ItemRepository;
import ru.milkparts.web.utils.MapperToItemPageDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class PageService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public PageService(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    public ItemPageDTO getItemPage(String itemId, String catId) {

        Category category = categoryRepository.findById(catId).orElseThrow(
                () -> new NotFoundException("No such category:" + catId));

        Item item = itemRepository.findItemByItemId(itemId).orElseThrow(
                () -> new NotFoundException("No such item:" + itemId));

        String cuttedDescription = stringCutter(item.getItemDescription());

        return MapperToItemPageDTO.toItemPageDTO(item, category, cuttedDescription);
    }

    private String stringCutter(String description) {
        Pattern pattern = Pattern.compile("<span>(.+?)</span>|<(/)?p>|<(/)?ul>|<(/)?li>");
        Matcher matcher = pattern.matcher(description);
        String newStr = matcher.replaceAll("");

        pattern = Pattern.compile("<(/)?br>");
        matcher = pattern.matcher(newStr);
        newStr = matcher.replaceAll(" ");
        return newStr;
    }

}
