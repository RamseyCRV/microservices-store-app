package com.crv.microstore.userservice.repository;

import com.crv.microstore.userservice.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomerModel, Long> {
}
