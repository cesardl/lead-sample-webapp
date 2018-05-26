package com.javachap.service;

import com.javachap.domain.Category;

import java.util.List;

public interface CategoryService extends Service {

    Category getCategory(Long categoryId);

    Category getCategory(String categoryName);

    Category save(Category category);

    List<Category> getAllCategories();
}
