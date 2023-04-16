package com.crv.microstore.smartadmin.Config;

public interface SmartAdminConstants {

    interface ControllerConstants{

        String URL_PATH_VARIABLE_ID = "/{id}";
        String URL_POST = "/new";
        String URL_PUT = "/update";
        String URL_DELETE = "/delete";
        String URL_FIND_BY_ID = "/find" + URL_PATH_VARIABLE_ID;
        String PATH_VARIABLE_ID = "id";
        String URL_DASHBOARD = "/dashboard";
        String URL_CATALOGS = "/catalog";
        String URL_PRODUCTS = "/product";
        String URL_CATEGORIES = "/category";
        String VIEW_DASHBOARD = "dashboardPage";
        String VIEW_CATALOGS = "catalogPage";
        String VIEW_CATEGORIES = "categoryPage";
        String VIEW_PRODUCTS = "productPage";



    }

}
