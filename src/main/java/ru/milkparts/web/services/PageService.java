package ru.milkparts.web.services;

import ru.milkparts.web.DTOs.CategoryPageDTO;
import ru.milkparts.web.DTOs.ItemPageDTO;


public interface PageService {
    CategoryPageDTO getCategoryPage(String catId);
    ItemPageDTO getItemPage(String itemId, String catId);
}
