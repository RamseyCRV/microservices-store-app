package com.crv.microstore.catalogservice.model;

import com.crv.microstore.catalogservice.config.CatalogConstants.ModelConstants;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = ModelConstants.ENTITY_PRODUCT)
public class ProductModel extends GenericModel < String > {

    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = ModelConstants.COLUMN_ID)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = ModelConstants.COLUMN_CATALOG)
    private CatalogModel catalog;

    @Column(name = ModelConstants.COLUMN_CATALOG_ID)
    private Long catalogId;

    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = ModelConstants.COLUMN_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ModelConstants.COLUMN_CATEGORY)
    private CategoryModel category;

    @Column(name = ModelConstants.COLUMN_CATEGORY_ID)
    private Long categoryId;

    @Column(name = ModelConstants.COLUMN_PRODUCT_STOCK)
    private int stock;

    @Column(name = ModelConstants.COLUMN_PRODUCT_PRICE)
    private double price;

    @Column(name = ModelConstants.COLUMN_PRODUCT_IMAGES)
    @ElementCollection(targetClass = String.class)
    private List<String> images = new ArrayList<>();

}
