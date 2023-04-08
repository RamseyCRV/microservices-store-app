package com.crv.microstore.catalogservice.service.impl;

import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.model.ProductModel;
import com.crv.microstore.catalogservice.repository.CategoryRepository;
import com.crv.microstore.catalogservice.repository.ProductRepository;
import com.crv.microstore.catalogservice.service.CategoryService;
import com.crv.microstore.catalogservice.testUtils.CsTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private CategoryService categoryService = new CategoryServiceImpl();
    private CategoryModel categoryModel;
    @BeforeEach
    void setUp() {
        categoryModel = CsTestUtils.createCategoryModel_NoSuperCategory();
    }

    @Test
    void getAllCategories() {
        List<CategoryModel> categoryModelList = CsTestUtils.createCategoryModelList();

        Mockito.when(categoryRepository.findAll()).thenReturn(categoryModelList);

        assertEquals(categoryModelList, categoryService.getAllCategories());
    }

    @Test
    void deleteCategoryById() {
        List<ProductModel> productModelList = CsTestUtils.createProductModelList();
        Mockito.when(productRepository.findAllByCategoryId(CsTestUtils.LONG_VALUE)).thenReturn(productModelList);

        categoryService.deleteCategoryById(CsTestUtils.LONG_VALUE);

        Mockito.verify(categoryRepository, Mockito.times(1)).deleteById(CsTestUtils.LONG_VALUE);
    }

    @Test
    void findCategoryById() {

        Mockito.when(categoryRepository.findById(CsTestUtils.LONG_VALUE)).thenReturn(Optional.of(categoryModel));

        assertEquals(categoryService.findCategoryById(CsTestUtils.LONG_VALUE), Optional.of(categoryModel));

    }

    @Test
    void saveCategory() {
        categoryService.saveCategory(categoryModel);

        Mockito.verify(categoryRepository, Mockito.times(1)).save(categoryModel);
    }
}