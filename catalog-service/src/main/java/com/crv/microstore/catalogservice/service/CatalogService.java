package com.crv.microstore.catalogservice.service;

import com.crv.microstore.catalogservice.model.CatalogModel;

import java.util.List;
import java.util.Optional;

public interface CatalogService {

    List<CatalogModel> getAllCatalogs();

    void saveCatalog(final CatalogModel catalogModel);

    /**
     * This method will delete the catalog using his id, alongside with the products from that catalog and the categories
     * @param id Catalog id
     */
    void deleteCatalogById(final Long id);

    Optional<CatalogModel> findCatalogById(final Long id);
}
