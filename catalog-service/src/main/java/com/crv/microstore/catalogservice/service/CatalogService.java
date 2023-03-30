package com.crv.microstore.catalogservice.service;

import com.crv.microstore.catalogservice.model.CatalogModel;

import java.util.List;
import java.util.Optional;

public interface CatalogService {

    List<CatalogModel> getAllCatalogs();

    void saveCatalog(final CatalogModel catalogModel);

    void deleteCatalogById(final Long id);

    Optional<CatalogModel> findCatalogById(final Long id);
}
