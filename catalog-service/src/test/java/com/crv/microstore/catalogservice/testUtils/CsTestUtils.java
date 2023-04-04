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

    public static final String STRING_FIELD = "stringText";
    public static final Long LONG_FIELD = 1L;


    public static CatalogModel createCatalogModel(){
        CatalogModel catalogModel = new CatalogModel();

        catalogModel.setId(LONG_FIELD);
        catalogModel.setName(STRING_FIELD);
        catalogModel.setDescription(STRING_FIELD);

        return catalogModel;
    }

    public static List<CatalogModel> createCatalogModelList(){
        List<CatalogModel> catalogModelList = new ArrayList<>();
        catalogModelList.add(createCatalogModel());

        return catalogModelList;
    }

    public static CategoryModel createCategoryModel_NoSuperCategory(){
        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId(LONG_FIELD);
        categoryModel.setName(STRING_FIELD);
        categoryModel.setDescription(STRING_FIELD);
        categoryModel.setCatalog(createCatalogModel());
        categoryModel.setCatalogId(LONG_FIELD);

        return categoryModel;
    }

    public static List<CategoryModel> createCategoryModelList(){
        List<CategoryModel> categoryModelList = new ArrayList<>();
        categoryModelList.add(createCategoryModel_NoSuperCategory());

        return categoryModelList;
    }

    public static ProductModel createProductModel(){
        ProductModel productModel = new ProductModel();

        productModel.setId(LONG_FIELD);
        productModel.setName(STRING_FIELD);
        productModel.setDescription(STRING_FIELD);
        productModel.setCategory(createCategoryModel_NoSuperCategory());
        productModel.setCategoryId(LONG_FIELD);
        productModel.setCatalog(createCatalogModel());
        productModel.setCatalogId(LONG_FIELD);

        return productModel;
    }

    public static List<ProductModel> createProductModelList(){
        List<ProductModel> productModelList = new ArrayList<>();
        productModelList.add(createProductModel());

        return productModelList;
    }
}
