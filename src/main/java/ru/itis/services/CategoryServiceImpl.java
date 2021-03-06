package ru.itis.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.exception.CategoryException;
import ru.itis.models.Category;
import ru.itis.repositories.CategoryRepository;

import java.util.List;
import java.util.function.Supplier;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow((Supplier<RuntimeException>) ()
                -> new CategoryException("Category with id: " + id + " not found"));
    }
}
