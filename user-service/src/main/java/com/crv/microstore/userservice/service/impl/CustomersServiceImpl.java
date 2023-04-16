package com.crv.microstore.userservice.service.impl;

import com.crv.microstore.userservice.model.CustomerModel;
import com.crv.microstore.userservice.repository.CustomersRepository;
import com.crv.microstore.userservice.service.CustomersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public List<CustomerModel> getAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Optional<CustomerModel> getCustomerById(final Long id) {
        return customersRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customersRepository.deleteById(id);
    }

    @Override
    public void saveCustomer(CustomerModel customerModel) {
        customersRepository.save(customerModel);
    }
}
