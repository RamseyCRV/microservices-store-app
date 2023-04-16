package com.crv.microstore.userservice.service.impl;

import com.crv.microstore.userservice.model.EmployeeModel;
import com.crv.microstore.userservice.repository.EmployeeRepository;
import com.crv.microstore.userservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeModel> getEmployeeById(final Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployeeById(final Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void saveEmployee(EmployeeModel employeeModel) {
        employeeRepository.save(employeeModel);
    }
}
