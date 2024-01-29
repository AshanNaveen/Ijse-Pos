package com.ijse.IjsePos.service;

import com.ijse.IjsePos.entity.Category;
import com.ijse.IjsePos.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category exitingCategory = categoryRepository.findById(id).orElse(null);

        if (exitingCategory != null){
            exitingCategory.setName(category.getName());
            return categoryRepository.save(exitingCategory);
        }
        else return null;
    }
}
