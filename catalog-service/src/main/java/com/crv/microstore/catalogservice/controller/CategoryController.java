package com.crv.microstore.catalogservice.controller;

import com.crv.microstore.catalogservice.config.CatalogConstants.ControllerConstants;
import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = ControllerConstants.CATEGORY_URL)
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public List<CategoryModel> getAllCategories(){
        return categoryService.getAllCategories();
    }
}