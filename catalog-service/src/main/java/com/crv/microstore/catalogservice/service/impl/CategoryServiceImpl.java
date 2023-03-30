package com.crv.microstore.catalogservice.service.impl;

import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.repository.CategoryRepository;
import com.crv.microstore.catalogservice.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<CategoryModel> getAllCategories() {
        log.debug("Returning {} categories", repository.findAll().size());
        return repository.findAll();
    }

    @Override
    public void deleteCategoryById(Long id) {
        log.debug("Start deleting category with id = {}", id);
        repository.deleteById(id);
        log.debug("Category was deleted with success...");
    }

    @Override
    public Optional<CategoryModel> findCategoryById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        repository.save(categoryModel);
        log.debug("{} category with id = {} was saved in the database", categoryModel.getName(), categoryModel.getId());
    }
}
