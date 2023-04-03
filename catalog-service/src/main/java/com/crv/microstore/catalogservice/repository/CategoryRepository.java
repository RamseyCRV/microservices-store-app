package com.crv.microstore.catalogservice.repository;

import com.crv.microstore.catalogservice.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    List<CategoryModel> findAllByCatalogId(final Long catalogId);

}
