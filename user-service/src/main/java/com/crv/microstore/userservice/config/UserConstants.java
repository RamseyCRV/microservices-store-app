package com.crv.microstore.userservice.config;

public interface UserConstants {

    interface ControllerConstants{
        String GENERIC_URL = "/api/v1/us";
        String EMPLOYEE_URL = GENERIC_URL + "/employee";
        String CUSTOMER_URL = GENERIC_URL + "/customer";
        String URL_PATH_VARIABLE_ID = "/{id}";
        String URL_POST = "/new";
        String URL_PUT = "/update";
        String URL_DELETE = "/delete";
        String URL_FIND_BY_ID = "/find" + URL_PATH_VARIABLE_ID;
        String PATH_VARIABLE_ID = "id";
    }

    interface ModelConstants{
        String TABLE_CUSTOMERS = "customers";
        String TABLE_EMPLOYEE = "employee";
        String COLUMN_ID = "id";
        String COLUMN_FIRST_NAME = "first_name";
        String COLUMN_LAST_NAME = "last_name";
        String COLUMN_DESCRIPTION = "description";
        String COLUM_EMAIL = "email";
        String COLUMN_PASSWORD = "password";
        String COLUMN_ROLE = "role";
    }


}
