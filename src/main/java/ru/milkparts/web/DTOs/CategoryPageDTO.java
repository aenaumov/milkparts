package ru.milkparts.web.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryPageDTO {

    private String catId;
    private String catRu;
    private String catDescription;
    private String catCuttedDescription;
    private String catKeywords;
    private List<ItemDTO> itemDTOs;

    @Getter
    @AllArgsConstructor
    public static class ItemDTO {
        private String itemId;
        private String itemRu;
    }
}
