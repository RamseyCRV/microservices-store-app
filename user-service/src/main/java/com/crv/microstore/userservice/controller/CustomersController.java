package com.crv.microstore.userservice.controller;

import com.crv.microstore.userservice.config.UserConstants.ControllerConstants;
import com.crv.microstore.userservice.model.CustomerModel;
import com.crv.microstore.userservice.service.CustomersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ControllerConstants.CUSTOMER_URL)
@Slf4j
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @GetMapping
    public List<CustomerModel> getAllCustomers(){
        return customersService.getAllCustomers();
    }
}
