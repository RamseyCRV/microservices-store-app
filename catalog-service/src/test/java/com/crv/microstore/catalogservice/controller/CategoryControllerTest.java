package com.crv.microstore.catalogservice.controller;

import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.service.CatalogService;
import com.crv.microstore.catalogservice.service.CategoryService;
import com.crv.microstore.catalogservice.testUtils.CsTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryControllerTest {

    @Mock
    private CategoryModel categoryModelMock;
    @Mock
    private CategoryService categoryService;
    @Mock
    private CatalogService catalogService;
    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllCategories() {
        List<CategoryModel> categoryModelList = CsTestUtils.createCategoryModelList();
        when(categoryService.getAllCategories()).thenReturn(categoryModelList);

        assertEquals(categoryModelList, categoryController.getAllCategories());
    }

    @Test
    void saveNewCategoryModel() {
        CategoryModel categoryModel = CsTestUtils.createCategoryModel_WithSuperCategory();
        when(catalogService.findCatalogById(CsTestUtils.LONG_VALUE)).thenReturn(Optional.of(CsTestUtils.createCatalogModel()));
        when(categoryService.findCategoryById(CsTestUtils.LONG_VALUE)).thenReturn(Optional.of(categoryModel.getSuperCategory()));

        categoryController.saveNewCategoryModel(categoryModel);

        verify(catalogService, times(2)).findCatalogById(CsTestUtils.LONG_VALUE);
    }

    @Test
    void deleteCategoryModel() {
        when(categoryService.findCategoryById(CsTestUtils.LONG_VALUE)).thenReturn(Optional.of(CsTestUtils.createCategoryModel_WithSuperCategory()));


        categoryController.deleteCategoryModel(CsTestUtils.LONG_VALUE);

        verify(categoryService, times(1)).deleteCategoryById(CsTestUtils.LONG_VALUE);
    }

    @Test
    void findCategoryModelById() {
        when(categoryService.findCategoryById(CsTestUtils.LONG_VALUE)).thenReturn(Optional.of(CsTestUtils.createCategoryModel_NoSuperCategory()));

        categoryController.findCategoryModelById(CsTestUtils.LONG_VALUE);

        verify(categoryService, times(2)).findCategoryById(CsTestUtils.LONG_VALUE);
    }

    @Test
    void updateCategoryModel() {
        CategoryModel categoryModel = CsTestUtils.createCategoryModel_WithSuperCategory();
        when(categoryService.findCategoryById(categoryModel.getSuperCategoryId())).thenReturn(Optional.of(CsTestUtils.createCategoryModel_NoSuperCategory()));
        when(catalogService.findCatalogById(categoryModel.getCatalogId())).thenReturn(Optional.of(CsTestUtils.createCatalogModel()));
        categoryController.updateCategoryModel(categoryModel);

        verify(categoryService, times(1)).saveCategory(categoryModel);
    }

}