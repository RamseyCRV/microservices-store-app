package com.crv.microstore.userservice.controller;

import com.crv.microstore.userservice.config.UserConstants.ControllerConstants;
import com.crv.microstore.userservice.model.EmployeeModel;
import com.crv.microstore.userservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ControllerConstants.EMPLOYEE_URL)
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
