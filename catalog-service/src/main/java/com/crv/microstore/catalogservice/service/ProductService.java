package com.crv.microstore.catalogservice.service;


import com.crv.microstore.catalogservice.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductModel> getAllProducts();

    void deleteProductById(final Long id);

    Optional<ProductModel> findProductById(final Long id);

    void saveProduct(ProductModel productModel);

}
