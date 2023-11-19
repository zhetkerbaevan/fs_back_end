package com.example.online_shop.services.impl;


import com.example.online_shop.entities.Category;
import com.example.online_shop.entities.Jewelry;
import com.example.online_shop.repositories.CategoryRepo;
import com.example.online_shop.repositories.JewelryRepo;
import com.example.online_shop.services.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JewelryServiceImpl implements JewelryService {
    @Autowired
    JewelryRepo jewelryRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<Jewelry> getAllJewelry() {
        return jewelryRepo.findAll();
    }
    @Override
    public Jewelry getJewelry(Long id) {
        return jewelryRepo.findById(id).get();
    }
    @Override
    public Jewelry saveJewelry(Jewelry jewelry) {
        return jewelryRepo.save(jewelry);
    }
    @Override
    public void deleteJewelry(Long id) {
        jewelryRepo.deleteById(id);
    }
    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }
    @Override
    public Category getCategory(Long id) {
        return categoryRepo.findById(id).get();
    }
    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }
    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
