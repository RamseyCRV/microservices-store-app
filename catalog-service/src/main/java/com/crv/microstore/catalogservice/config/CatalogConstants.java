package com.crv.microstore.catalogservice.config;

public interface CatalogConstants {

    interface ControllerConstants{

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
