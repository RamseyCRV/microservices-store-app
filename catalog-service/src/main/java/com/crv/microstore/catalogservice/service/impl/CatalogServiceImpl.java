package com.crv.microstore.catalogservice.service.impl;

import com.crv.microstore.catalogservice.model.CatalogModel;
import com.crv.microstore.catalogservice.model.CategoryModel;
import com.crv.microstore.catalogservice.model.ProductModel;
import com.crv.microstore.catalogservice.repository.CatalogRepository;
import com.crv.microstore.catalogservice.repository.CategoryRepository;
import com.crv.microstore.catalogservice.repository.ProductRepository;
import com.crv.microstore.catalogservice.service.CatalogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CatalogModel> getAllCatalogs() {
        log.debug("Returning {} catalog models", catalogRepository.findAll().size());
        return catalogRepository.findAll();
    }

    @Override
    public void saveCatalog(final CatalogModel catalogModel) {
        catalogRepository.save(catalogModel);
        log.debug("{} catalog with the id {} was saved in the database", catalogModel.getName(), catalogModel.getId());
    }


    @Override
    public void deleteCatalogById(final Long id) {
        log.debug("Start deleting catalog with id {} from the database", id);
        List<ProductModel> productsFromCatalog = productRepository.findAllByCatalogId(id);
        List<CategoryModel> categoriesFromCatalog = categoryRepository.findAllByCatalogId(id);

        if (!ObjectUtils.isEmpty(productsFromCatalog)){
            log.info("{} products from catalog id = {} will be deleted...", productsFromCatalog.size(), id);
            productRepository.deleteAll(productsFromCatalog);
            productRepository.flush();
        }

        if(!ObjectUtils.isEmpty(categoriesFromCatalog)){
            log.info("{} categories will be deleted from catalog id = {}", categoriesFromCatalog.size(), id);
            categoryRepository.deleteAll(categoriesFromCatalog);
            categoryRepository.flush();
        }

        catalogRepository.deleteById(id);
        log.debug("Catalog was deleted with success...");
    }

    @Override
    public Optional<CatalogModel> findCatalogById(Long id) {
        return catalogRepository.findById(id);
    }
}
