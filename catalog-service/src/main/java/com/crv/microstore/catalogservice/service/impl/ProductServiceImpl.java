package com.crv.microstore.catalogservice.service.impl;

import com.crv.microstore.catalogservice.model.ProductModel;
import com.crv.microstore.catalogservice.repository.ProductRepository;
import com.crv.microstore.catalogservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<ProductModel> getAllProducts() {
        log.debug("Returning {} products", repository.findAll().size());
        return repository.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
        log.debug("Start deleting product with id = {}", id);
        repository.deleteById(id);
        log.debug("Product with id = {} was deleted with success...", id);
    }

    @Override
    public Optional<ProductModel> findProductById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void saveProduct(ProductModel productModel) {
        repository.save(productModel);
        log.debug("Product {} with id = {} was saved with success in the database...", productModel.getName(), productModel.getId());
    }
}
