package com.crv.microstore.catalogservice.service.impl;

import com.crv.microstore.catalogservice.model.CatalogModel;
import com.crv.microstore.catalogservice.repository.CatalogRepository;
import com.crv.microstore.catalogservice.service.CatalogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository repository;

    @Override
    public List<CatalogModel> getAllCatalogs() {
        log.debug("Returning {} catalog models", repository.findAll().size());
        return repository.findAll();
    }

    @Override
    public void saveCatalog(final CatalogModel catalogModel) {
        repository.save(catalogModel);
        log.debug("{} catalog with the id {} was saved in the database", catalogModel.getName(), catalogModel.getId());
    }

    @Override
    public void deleteCatalogById(final Long id) {
        log.debug("Start deleting catalog with id {} from the database", id);
        repository.deleteById(id);
        log.debug("Catalog was deleted with success...");
    }

    @Override
    public Optional<CatalogModel> findCatalogById(Long id) {
        return repository.findById(id);
    }
}
