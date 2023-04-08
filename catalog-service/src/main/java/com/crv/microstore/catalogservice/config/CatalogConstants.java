package com.crv.microstore.catalogservice.config;

public interface CatalogConstants {

    interface ControllerConstants{
        String GENERIC_URL = "/api/v1/cs";
        String CATALOG_URL = GENERIC_URL + "/catalog";
        String CATEGORY_URL = GENERIC_URL + "/category";
        String PRODUCT_URL = GENERIC_URL + "/product";
        String URL_PATH_VARIABLE_ID = "/{id}";
        String URL_POST = "/new";
        String URL_PUT = "/update";
        String URL_DELETE = "/delete";
        String URL_FIND_BY_ID = "/find" + URL_PATH_VARIABLE_ID;
        String PATH_VARIABLE_ID = "id";

    }

    interface ModelConstants{
        String ENTITY_CATALOG = "catalog";
        String ENTITY_CATEGORY = "category";
        String ENTITY_PRODUCT = "product";
        String COLUMN_CATALOG = "catalog";
        String COLUMN_CATALOG_ID = "catalogId";
        String COLUMN_CATEGORY = "category";
        String COLUMN_CATEGORY_ID = "categoryId";
        String COLUMN_SUPER_CATEGORY = "superCategory";
        String COLUMN_SUPER_CATEGORY_ID = "superCategoryId";
        String COLUMN_ID = "id";
        String COLUMN_NAME = "name";
        String COLUMN_DESCRIPTION = "description";
        String COLUMN_CATALOG_PRODUCTS = "products";
        String COLUMN_CATALOG_CATEGORIES = "categories";
        String COLUMN_PRODUCT_STOCK = "stock";
        String COLUMN_PRODUCT_PRICE = "price";
        String COLUMN_PRODUCT_IMAGES = "images";

    }

    interface ServiceConstants{

    }

}
