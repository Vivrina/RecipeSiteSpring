package ru.itis.services;

import ru.itis.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findCategories();
    Category getCategory(Long id);
}
