package com.example.online_shop.services;

import com.example.online_shop.entities.Category;
import com.example.online_shop.entities.Jewelry;

import java.util.List;

public interface JewelryService {
    List<Jewelry> getAllJewelry();
    Jewelry getJewelry(Long id);
    Jewelry saveJewelry(Jewelry jewelry);
    void deleteJewelry(Long id);

    List<Category> getAllCategory();
    Category getCategory(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
