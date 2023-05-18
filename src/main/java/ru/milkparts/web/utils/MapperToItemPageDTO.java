package ru.milkparts.web.utils;

import ru.milkparts.web.models.DTOs.ItemPageDTO;
import ru.milkparts.web.models.Category;
import ru.milkparts.web.models.Item;

public final class MapperToItemPageDTO {

    private MapperToItemPageDTO() {

    }

    public static ItemPageDTO toItemPageDTO(Item item,  Category category, String cuttedDescription) {
        return new ItemPageDTO(
                item.getItemId(),
                item.getItemRu(),
                item.getItemDescription(),
                cuttedDescription,
                item.getItemKeywords(),
                item.getCatCanonicalId(),
                item.getItemFirstPage(),
                category.getCatId(),
                category.getCatRu(),
                category.getCatKeywords());
    }
}
