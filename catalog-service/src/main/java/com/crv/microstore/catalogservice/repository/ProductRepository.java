package com.crv.microstore.catalogservice.repository;

import com.crv.microstore.catalogservice.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findAllByCatalogId(final Long catalogId);

    List<ProductModel> findAllByCategoryId(final Long categoryId);
}
