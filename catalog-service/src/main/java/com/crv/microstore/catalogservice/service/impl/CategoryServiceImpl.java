package com.crv.microstore.catalogservice.service.impl;

import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.model.ProductModel;
import com.crv.microstore.catalogservice.repository.CategoryRepository;
import com.crv.microstore.catalogservice.repository.ProductRepository;
import com.crv.microstore.catalogservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategoryById(Long id) {
        log.debug("Start deleting category with id = {}", id);
        List<ProductModel> productsFromCategory = productRepository.findAllByCategoryId(id);

        if(ObjectUtils.isNotEmpty(productsFromCategory)){
            log.info("{} products from category id = {} will be deleted...", productsFromCategory.size(), id);
            productRepository.deleteAll(productsFromCategory);
            productRepository.flush();
        }

        categoryRepository.deleteById(id);
        log.debug("Category was deleted with success...");
    }

    @Override
    public Optional<CategoryModel> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryModel);
        log.debug("{} category with id = {} was saved in the database", categoryModel.getName(), categoryModel.getId());
    }
}
