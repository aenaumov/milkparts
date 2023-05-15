package ru.milkparts.web.services;

import org.springframework.stereotype.Service;
import ru.milkparts.web.models.DTOs.CategoryPageDTO;
import ru.milkparts.web.models.DTOs.ItemPageDTO;
import ru.milkparts.web.exceptions.NotFoundException;
import ru.milkparts.web.models.Category;
import ru.milkparts.web.models.Item;
import ru.milkparts.web.repositories.CategoryRepository;
import ru.milkparts.web.repositories.ItemRepository;
import ru.milkparts.web.utils.MapperToCategoryPageDTO;
import ru.milkparts.web.utils.MapperToItemPageDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PageServiceImpl implements PageService{

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public PageServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryPageDTO getCategoryPage(String catId){
        final Category category = getCategoryFetchItems(catId);
        final String cuttedDescription=stringCutter(category.getCatDescription());

        return MapperToCategoryPageDTO.toCategoryPageDTO(category, cuttedDescription);
    }

    @Override
    public ItemPageDTO getItemPage(String itemId, String catId) {

        final Category category = getCategoryWithoutFetchItems(catId);

        final Item item = itemRepository.findItemByItemId(itemId).orElseThrow(
                () -> new NotFoundException("No such item:" + itemId));

        final String cuttedDescription = stringCutter(item.getItemDescription());

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

    private Category getCategoryFetchItems(String catId){
        return categoryRepository.findById(catId).orElseThrow(
                () -> new NotFoundException("No such category:" + catId));
    }

    private Category getCategoryWithoutFetchItems(String catId){
        return categoryRepository.findCategoryByCatId(catId).orElseThrow(
                () -> new NotFoundException("No such category:" + catId));
    }
}

