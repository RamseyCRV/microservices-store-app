package com.crv.microstore.catalogservice.controller;

import com.crv.microstore.catalogservice.model.CatalogModel;
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
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CatalogControllerTest {

    @Mock
    private CatalogService catalogService;

    @InjectMocks
    private CatalogController catalogController;

    @Test
    void getAllCatalogs() {
        List<CatalogModel> catalogModelList = CsTestUtils.createCatalogModelList();
        Mockito.when(catalogService.getAllCatalogs()).thenReturn(catalogModelList);

        assertEquals(catalogController.getAllCatalogs(), catalogModelList);

    }

    @Test
    void saveNewCatalogModel() {
        CatalogModel catalogModel = CsTestUtils.createCatalogModel();

        catalogController.saveNewCatalogModel(catalogModel);

        Mockito.verify(catalogService, Mockito.times(1)).saveCatalog(catalogModel);
    }

    @Test
    void saveNewCatalogModel_withNullValue() {

        catalogController.saveNewCatalogModel(null);

        Mockito.verify(catalogService, Mockito.times(0)).saveCatalog(Mockito.any());
    }

    @Test
    void deleteCatalog() {
        catalogController.deleteCatalog(CsTestUtils.LONG_VALUE);

        Mockito.verify(catalogService, Mockito.times(1)).deleteCatalogById(CsTestUtils.LONG_VALUE);
    }

    @Test
    void findCatalogModelById() {
        Mockito.when(catalogService.findCatalogById(CsTestUtils.LONG_VALUE)).thenReturn(Optional.of(CsTestUtils.createCatalogModel()));

        catalogController.findCatalogModelById(CsTestUtils.LONG_VALUE);

        Mockito.verify(catalogService, Mockito.times(1)).findCatalogById(CsTestUtils.LONG_VALUE);
    }

    @Test
    void findCatalogModelById_withNullValue() {
        catalogController.findCatalogModelById(null);

        Mockito.verify(catalogService, Mockito.times(0)).findCatalogById(Mockito.any());
    }

    @Test
    void updateCatalogModel() {
        CatalogModel catalogModel = CsTestUtils.createCatalogModel();

        catalogController.updateCatalogModel(catalogModel);

        Mockito.verify(catalogService, Mockito.times(1)).saveCatalog(catalogModel);
    }

    @Test
    void updateCatalogModel_withNullValue() {
        catalogController.updateCatalogModel(null);

        Mockito.verify(catalogService, Mockito.times(0)).saveCatalog(Mockito.any());
    }
}