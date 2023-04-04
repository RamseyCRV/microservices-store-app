package com.crv.microstore.catalogservice.service.impl;

import com.crv.microstore.catalogservice.model.CatalogModel;
import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.model.ProductModel;
import com.crv.microstore.catalogservice.repository.CatalogRepository;
import com.crv.microstore.catalogservice.repository.CategoryRepository;
import com.crv.microstore.catalogservice.repository.ProductRepository;
import com.crv.microstore.catalogservice.service.CatalogService;
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

import static junit.framework.TestCase.assertEquals;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CatalogServiceImplTest {

    @Mock
    private CatalogRepository catalogRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CatalogService catalogService = new CatalogServiceImpl();

    private CatalogModel catalog;
    private ProductModel product;
    private CategoryModel category;
    @BeforeEach
    void setUp() {

        catalog = CsTestUtils.createCatalogModel();
        category = CsTestUtils.createCategoryModel_NoSuperCategory();
        product = CsTestUtils.createProductModel();

    }

    @Test
    void getAllCatalogs() {
        List<CatalogModel> catalogModelList = CsTestUtils.createCatalogModelList();

        Mockito.when(catalogRepository.findAll()).thenReturn(catalogModelList);

        List<CatalogModel> catalogModels = catalogService.getAllCatalogs();

        assertEquals(catalogModels, catalogModelList);
    }

    @Test
    void saveCatalog() {
        catalogService.saveCatalog(catalog);

        Mockito.verify(catalogRepository, Mockito.times(1)).save(catalog);
    }

    @Test
    void deleteCatalogById() {
        List<CategoryModel> categoryModelList = CsTestUtils.createCategoryModelList();
        List<ProductModel> productModelList = CsTestUtils.createProductModelList();

        Mockito.when(productRepository.findAllByCatalogId(product.getId())).thenReturn(productModelList);
        Mockito.when(categoryRepository.findAllByCatalogId(category.getId())).thenReturn(categoryModelList);

        catalogService.deleteCatalogById(catalog.getId());

        Mockito.verify(catalogRepository, Mockito.times(1)).deleteById(catalog.getId());
    }

    @Test
    void findCatalogById() {
        catalogService.findCatalogById(catalog.getId());

        Mockito.verify(catalogRepository, Mockito.times(1)).findById(catalog.getId());
    }

}