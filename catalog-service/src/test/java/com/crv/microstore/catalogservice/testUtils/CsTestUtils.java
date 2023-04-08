package com.crv.microstore.catalogservice.testUtils;

import com.crv.microstore.catalogservice.model.CatalogModel;
import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public final class CsTestUtils {

    private CatalogModel catalog;
    private CategoryModel category;
    private ProductModel product;

    public static final String STRING_VALUE = "stringText";
    public static final Long LONG_VALUE = 1L;


    public static CatalogModel createCatalogModel(){
        CatalogModel catalogModel = new CatalogModel();

        catalogModel.setId(LONG_VALUE);
        catalogModel.setName(STRING_VALUE);
        catalogModel.setDescription(STRING_VALUE);

        return catalogModel;
    }

    public static List<CatalogModel> createCatalogModelList(){
        List<CatalogModel> catalogModelList = new ArrayList<>();
        catalogModelList.add(createCatalogModel());

        return catalogModelList;
    }

    public static CategoryModel createCategoryModel_NoSuperCategory(){
        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId(LONG_VALUE);
        categoryModel.setName(STRING_VALUE);
        categoryModel.setDescription(STRING_VALUE);
        categoryModel.setCatalog(createCatalogModel());
        categoryModel.setCatalogId(LONG_VALUE);

        return categoryModel;
    }

    public static CategoryModel createCategoryModel_WithSuperCategory(){
        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId(2L);
        categoryModel.setName(STRING_VALUE);
        categoryModel.setDescription(STRING_VALUE);
        categoryModel.setCatalog(createCatalogModel());
        categoryModel.setCatalogId(LONG_VALUE);
        categoryModel.setSuperCategoryId(LONG_VALUE);
        categoryModel.setSuperCategory(createCategoryModel_NoSuperCategory());

        return categoryModel;
    }

    public static List<CategoryModel> createCategoryModelList(){
        List<CategoryModel> categoryModelList = new ArrayList<>();
        categoryModelList.add(createCategoryModel_NoSuperCategory());

        return categoryModelList;
    }

    public static ProductModel createProductModel(){
        ProductModel productModel = new ProductModel();

        productModel.setId(LONG_VALUE);
        productModel.setName(STRING_VALUE);
        productModel.setDescription(STRING_VALUE);
        productModel.setCategory(createCategoryModel_NoSuperCategory());
        productModel.setCategoryId(LONG_VALUE);
        productModel.setCatalog(createCatalogModel());
        productModel.setCatalogId(LONG_VALUE);

        return productModel;
    }

    public static List<ProductModel> createProductModelList(){
        List<ProductModel> productModelList = new ArrayList<>();
        productModelList.add(createProductModel());

        return productModelList;
    }
}
