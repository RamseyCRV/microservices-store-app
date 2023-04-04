package com.crv.microstore.catalogservice.controller;

import com.crv.microstore.catalogservice.config.CatalogConstants.ControllerConstants;
import com.crv.microstore.catalogservice.model.ProductModel;
import com.crv.microstore.catalogservice.service.CatalogService;
import com.crv.microstore.catalogservice.service.CategoryService;
import com.crv.microstore.catalogservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @PostMapping(value = ControllerConstants.URL_POST)
    public void saveProduct(@RequestBody ProductModel productModel) {

        if (ObjectUtils.isNotEmpty(productModel)) {
            productModel.setCatalog(catalogService.findCatalogById(productModel.getCatalogId()).get());
            productModel.setCategory(categoryService.findCategoryById(productModel.getCategoryId()).get());

            productService.saveProduct(productModel);

            log.info("{} product was saved with success in the database...", productModel.getName());
        } else {
            log.error("Product is empty or null. The product was not saved in the database...");
        }
    }

    @DeleteMapping(value = ControllerConstants.URL_DELETE)
    public void deleteProduct(@RequestBody final Long id) {

        if (ObjectUtils.isNotEmpty(id)) {
            productService.deleteProductById(id);
        } else {
            log.error("The id is null, no product found to delete...");
        }
    }

    @GetMapping(value = ControllerConstants.URL_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findProductModelById(@PathVariable(ControllerConstants.PATH_VARIABLE_ID) Long id) {

        ProductModel productModel = null;

        if (ObjectUtils.isNotEmpty(id)) {
            productModel = productService.findProductById(id).get();

            log.info("{} product was find with id = {}", productModel.getName(), id);
            return new ResponseEntity<>(productModel, HttpStatus.ACCEPTED);
        } else {
            log.error("The id is null, no product found...");
            return new ResponseEntity<>(productModel, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = ControllerConstants.URL_PUT, method = {RequestMethod.PUT, GET})
    public void updateProductModel(@RequestBody ProductModel productModel) {

        if (ObjectUtils.isNotEmpty(productModel)) {

            Long newCatalogId = productModel.getCatalogId();
            Long newCategoryId = productModel.getCategoryId();

            ProductModel oldProductModel = productService.findProductById(productModel.getId()).get();

            if (ObjectUtils.notEqual(newCatalogId, oldProductModel.getCatalogId())) {
                productModel.setCatalogId(newCatalogId);
                productModel.setCatalog(catalogService.findCatalogById(newCatalogId).get());
            }

            if (ObjectUtils.notEqual(newCategoryId, oldProductModel.getCategoryId())) {
                productModel.setCategoryId(newCategoryId);
                productModel.setCategory(categoryService.findCategoryById(newCategoryId).get());
            }

            productService.saveProduct(productModel);

            log.info("{} product was updated with success...", productModel.getName());
        }else{
            log.error("The product sent is null or empty, no product was updated into database...");
        }
    }
}
