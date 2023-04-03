package com.crv.microstore.catalogservice.controller;

import com.crv.microstore.catalogservice.config.CatalogConstants.ControllerConstants;
import com.crv.microstore.catalogservice.model.ProductModel;
import com.crv.microstore.catalogservice.service.CatalogService;
import com.crv.microstore.catalogservice.service.CategoryService;
import com.crv.microstore.catalogservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = ControllerConstants.PRODUCT_URL)
public class ProductController {

    private final ProductService productService;
    private final CatalogService catalogService;
    private final CategoryService categoryService;

    @GetMapping
    public List<ProductModel> getAllProducts(){
        return productService.getAllProducts();
    }
}
