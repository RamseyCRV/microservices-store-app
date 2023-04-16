package com.crv.microstore.userservice.service;

import com.crv.microstore.userservice.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface CustomersService {

    List<CustomerModel> getAllCustomers();
    Optional<CustomerModel> getCustomerById(final Long id);
    void deleteCustomerById(final Long id);
    void saveCustomer(final CustomerModel customerModel);

}
