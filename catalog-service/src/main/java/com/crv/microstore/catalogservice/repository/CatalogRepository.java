package com.crv.microstore.catalogservice.repository;

import com.crv.microstore.catalogservice.model.CatalogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogModel, Long> {
}
