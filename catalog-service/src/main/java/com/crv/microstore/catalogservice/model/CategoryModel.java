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

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = ModelConstants.ENTITY_CATEGORY)
public class CategoryModel extends GenericModel < String > {

    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = ModelConstants.COLUMN_ID)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = ModelConstants.COLUMN_CATALOG)
    private CatalogModel catalog;

    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = ModelConstants.COLUMN_ID)
    @OneToMany(mappedBy = ModelConstants.COLUMN_CATEGORY, fetch = FetchType.LAZY)
    private Set<ProductModel> products;

    @Column(name = ModelConstants.COLUMN_CATALOG_ID)
    private Long catalogId;

    @Column(name = ModelConstants.COLUMN_SUPER_CATEGORY_ID)
    private Long superCategoryId;

    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = ModelConstants.COLUMN_ID)
    @ManyToOne
    @JoinColumn(name = ModelConstants.COLUMN_SUPER_CATEGORY)
    private CategoryModel superCategory;

    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = ModelConstants.COLUMN_ID)
    @OneToMany(mappedBy = ModelConstants.COLUMN_SUPER_CATEGORY)
    private Set<CategoryModel> subCategories;

}