package com.crv.microstore.catalogservice.service.impl;

import com.crv.microstore.catalogservice.model.ProductModel;
import com.crv.microstore.catalogservice.repository.ProductRepository;
import com.crv.microstore.catalogservice.service.ProductService;
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
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService = new ProductServiceImpl();

    @Test
    void getAllProducts() {
        List<ProductModel> productModelList = CsTestUtils.createProductModelList();
        Mockito.when(productRepository.findAll()).thenReturn(productModelList);

        assertEquals(productModelList, productService.getAllProducts());
    }

    @Test
    void deleteProductById() {
        productService.deleteProductById(CsTestUtils.LONG_FIELD);

        Mockito.verify(productRepository, Mockito.times(1)).deleteById(CsTestUtils.LONG_FIELD);
    }

    @Test
    void findProductById() {
        productService.findProductById(CsTestUtils.LONG_FIELD);

        Mockito.verify(productRepository, Mockito.times(1)).findById(CsTestUtils.LONG_FIELD);
    }

    @Test
    void saveProduct() {
        final ProductModel productModel = CsTestUtils.createProductModel();

        productService.saveProduct(productModel);

        Mockito.verify(productRepository, Mockito.times(1)).save(productModel);

    }
}