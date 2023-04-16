package com.crv.microstore.userservice.service;

import com.crv.microstore.userservice.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeModel> getAllEmployees();
    Optional<EmployeeModel> getEmployeeById(final Long id);
    void deleteEmployeeById(final Long id);
    void saveEmployee(final EmployeeModel employeeModel);
}
