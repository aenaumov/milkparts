package ru.milkparts.web.services;

import ru.milkparts.web.models.DTOs.CategoryPageDTO;
import ru.milkparts.web.models.DTOs.ItemPageDTO;


public interface PageService {
    CategoryPageDTO getCategoryPage(String catId);
    ItemPageDTO getItemPage(String itemId, String catId);
}
