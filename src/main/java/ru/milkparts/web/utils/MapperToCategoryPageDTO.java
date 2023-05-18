package ru.milkparts.web.utils;

import ru.milkparts.web.models.DTOs.CategoryPageDTO;
import ru.milkparts.web.models.Category;
import ru.milkparts.web.models.Item;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class MapperToCategoryPageDTO {

    private MapperToCategoryPageDTO() {

    }

    public static CategoryPageDTO toCategoryPageDTO(Category category, String cuttedDescription) {
        return new CategoryPageDTO(
                category.getCatId(),
                category.getCatRu(),
                category.getCatDescription(),
                cuttedDescription,
                category.getCatKeywords(),
                toItemDTOs(category.getItems()));
    }

    private static List<CategoryPageDTO.ItemDTO> toItemDTOs(Set<Item> items) {
        return items
                .stream()
                .map(i -> new CategoryPageDTO.ItemDTO(i.getItemId(), i.getItemRu()))
                .collect(Collectors.toList());
    }
}