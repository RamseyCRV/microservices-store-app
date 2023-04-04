package com.crv.microstore.catalogservice.controller;

import com.crv.microstore.catalogservice.config.CatalogConstants.ControllerConstants;
import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.service.CatalogService;
import com.crv.microstore.catalogservice.service.CategoryService;
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
@RequestMapping(value = ControllerConstants.CATEGORY_URL)
public class CategoryController {

    private CategoryService categoryService;
    private CatalogService catalogService;

    @GetMapping
    public List<CategoryModel> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping(value = ControllerConstants.URL_POST)
    public void saveNewCatalogModel(@RequestBody CategoryModel categoryModel){
        if(ObjectUtils.isNotEmpty(categoryModel)){

            if(ObjectUtils.isNotEmpty(categoryModel.getCatalogId())
                    && ObjectUtils.isNotEmpty(catalogService.findCatalogById(categoryModel.getCatalogId()))) {

                categoryModel.setCatalog(catalogService.findCatalogById(categoryModel.getCatalogId()).get());

                if(ObjectUtils.isNotEmpty(categoryModel.getSuperCategoryId())
                        && ObjectUtils.isNotEmpty(categoryService.findCategoryById(categoryModel.getSuperCategoryId()))){
                    categoryModel.setSuperCategory(categoryService.findCategoryById(categoryModel.getSuperCategoryId()).get());
                }

                categoryService.saveCategory(categoryModel);
            }else{
                log.error("There is no existing catalog with id = {}", categoryModel.getCatalogId());
            }

            log.info(" {} catalog with the Id {} was saved in the database...", categoryModel.getName(), categoryModel.getId());
        }else{
            log.error("The catalog was not saved because the object is NULL / EMPTY");
        }
    }

    @DeleteMapping(value = ControllerConstants.URL_DELETE)
    public void deleteCategoryModel(@RequestBody Long id){

        if(ObjectUtils.isNotEmpty(id) && ObjectUtils.isNotEmpty(categoryService.findCategoryById(id))){

            CategoryModel categoryModel = categoryService.findCategoryById(id).get();

            if(ObjectUtils.isNotEmpty(categoryModel.getSuperCategory())){

                final Long superCategoryId = categoryModel.getSuperCategory().getId();

                categoryModel.getSuperCategory().setSuperCategory(null);
                categoryModel.setSuperCategoryId(null);

                categoryService.saveCategory(categoryService.findCategoryById(superCategoryId).get());

                log.info("SuperCategory with id = {} is now clean", superCategoryId);
            }

            if(ObjectUtils.isNotEmpty(categoryModel.getSubCategories())){

                for (CategoryModel subCategory : categoryService.findCategoryById(id).get().getSubCategories()) {

                    subCategory.setSuperCategory(null);
                    subCategory.setSuperCategoryId(null);
                    categoryService.saveCategory(subCategory);

                    log.info("SubCategory with id = {} has set the superCategory to null", subCategory.getId());
                }
                categoryModel.setSubCategories(null);
            }

            categoryService.deleteCategoryById(id);

            log.info("Category with id = {} is now deleted...", id);

        }else{
            log.error("The id or the category with that id, do not exist...");
        }
    }

    @GetMapping(value = ControllerConstants.URL_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCategoryModelById(@PathVariable(ControllerConstants.PATH_VARIABLE_ID) Long id){

        CategoryModel categoryModel = null;

        if (ObjectUtils.isNotEmpty(id) && ObjectUtils.isNotEmpty(categoryService.findCategoryById(id))) {
            categoryModel = categoryService.findCategoryById(id).get();

            log.info("{} category with id = {} is found | returning 200", categoryModel.getName(), categoryModel.getId());

            return new ResponseEntity<>(categoryModel, HttpStatus.ACCEPTED);
        }
        else{
            log.error("The id is null or the id is not associated with any category");
            return new ResponseEntity<>(categoryModel, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = ControllerConstants.URL_PUT, method = {RequestMethod.PUT, GET})
    public void updateCategoryModel(@RequestBody CategoryModel categoryModel){

        if(ObjectUtils.isNotEmpty(categoryModel)) {

            if(ObjectUtils.isNotEmpty(categoryModel.getSuperCategoryId())){
                categoryModel.setSuperCategory(categoryService.findCategoryById(categoryModel.getSuperCategoryId()).get());
            }

            if (ObjectUtils.isEmpty(categoryModel.getCatalogId())){
                final Long catalogId = categoryService.findCategoryById(categoryModel.getId()).get().getCatalogId();
                categoryModel.setCatalogId(catalogId);
                categoryModel.setCatalog(catalogService.findCatalogById(catalogId).get());
            }else{
                categoryModel.setCatalog(catalogService.findCatalogById(categoryModel.getCatalogId()).get());
            }

            categoryService.saveCategory(categoryModel);

            log.info("{} category with id = {} was updated with success", categoryModel.getName(), categoryModel.getId());
        }else{
            log.error("The category model sent via request is null...");
        }
    }

}
