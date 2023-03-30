package com.crv.microstore.catalogservice.service;

import com.crv.microstore.catalogservice.model.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryModel> getAllCategories();

    void deleteCategoryById(final Long id);

    Optional<CategoryModel> findCategoryById(final Long id);

    void saveCategory(CategoryModel categoryModel);
}
