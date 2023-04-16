//package com.crv.microstore.smartadmin.Service;
//
//import com.crv.eCommerce.smartadmin.Rest.CatalogService.Models.CatalogModel;
//import com.crv.eCommerce.smartadmin.Rest.CatalogService.Models.CategoryModel;
//import com.crv.eCommerce.smartadmin.Rest.CatalogService.Models.ProductModel;
//import com.crv.eCommerce.smartadmin.Rest.RestConstants.CatalogServiceConstants;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * Created by robert on 11.08.2022
// * <b>Feign client for <i>catalog-service</i> API</b>
// */
//@FeignClient(value = CatalogServiceConstants.APPLICATION_NAME)
//public interface CatalogServiceFeignClient {
//
//    // ProductModel calls
//    @GetMapping(value = CatalogServiceConstants.ROOT_PRODUCTS)
//    List<ProductModel> getAllProductModels();
//
//    @RequestMapping(method = RequestMethod.POST, value = CatalogServiceConstants.NEW_PRODUCT, consumes = "application/json")
//    ProductModel saveNewProductModel(@RequestBody ProductModel productModel);
//
//    @RequestMapping(method = RequestMethod.PUT, value = CatalogServiceConstants.UPDATE_PRODUCT , consumes = "application/json")
//    ProductModel updateExistingProductModel(@RequestBody ProductModel productModel);
//
//    @DeleteMapping(value = CatalogServiceConstants.DELETE_PRODUCT)
//    void deleteProductModelById(@Param("id") Long id);
//
//    @RequestMapping(value = CatalogServiceConstants.FIND_PRODUCT_BY_ID + "/{id}", method = RequestMethod.GET, produces = "application/json")
//    ResponseEntity<?> findProductModelById(@PathVariable(value = "id") Long id);
//
//    // CatalogModel calls
//    @GetMapping(value = CatalogServiceConstants.ROOT_CATALOGS)
//    List<CatalogModel> getAllCatalogModels();
//
//    @RequestMapping(method = RequestMethod.POST, value = CatalogServiceConstants.NEW_CATALOG, consumes = "application/json")
//    CatalogModel saveNewCatalogModel(@RequestBody CatalogModel catalogModel);
//
//    @RequestMapping(method = RequestMethod.PUT, value = CatalogServiceConstants.UPDATE_CATALOG, consumes = "application/json")
//    CatalogModel updateExistingCatalogModel(@RequestBody CatalogModel catalogModel);
//
//    @DeleteMapping(value = CatalogServiceConstants.DELETE_CATALOG)
//    void deleteCatalogModelById(@Param("id") Long id);
//
//    @RequestMapping(value = CatalogServiceConstants.FIND_CATALOG_BY_ID + "/{id}", method = RequestMethod.GET, produces = "application/json")
//    ResponseEntity<?> findCatalogModelById(@PathVariable(value = "id") Long id);
//
//    // CategoryModel calls
//    @GetMapping(value = CatalogServiceConstants.ROOT_CATEGORIES)
//    List<CategoryModel> getAllCategoryModels();
//
//    @RequestMapping(method = RequestMethod.POST, value = CatalogServiceConstants.NEW_CATEGORY, consumes = "application/json")
//    CategoryModel saveNewCategoryModel(@RequestBody CategoryModel categoryModel);
//
//    @RequestMapping(method = RequestMethod.PUT, value = CatalogServiceConstants.UPDATE_CATEGORY , consumes = "application/json")
//    CategoryModel updateExistingCategoryModel(@RequestBody CategoryModel categoryModel);
//
//    @DeleteMapping(value = CatalogServiceConstants.DELETE_CATEGORY)
//    void deleteCategoryModelById(@Param("id") Long id);
//
//    @RequestMapping(value = CatalogServiceConstants.FIND_CATEGORY_BY_ID + "/{id}", method = RequestMethod.GET, produces = "application/json")
//    ResponseEntity<?> findCategoryModelById(@PathVariable(value = "id") Long id);
//}
