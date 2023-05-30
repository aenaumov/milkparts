package ru.milkparts.web.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemPageDTO {

    private String itemId;
    private String itemRu;
    private String itemDescription;
    private String itemCuttedDescription;
    private String itemKeywords;
    private String itemCatCanonicalId;
    private Boolean itemFirstPage;
    private String catId;
    private String catRu;
    private String catKeywords;

}
