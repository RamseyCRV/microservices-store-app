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
@Entity(name = ModelConstants.ENTITY_CATALOG)
public class CatalogModel extends GenericModel < String > {

    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = ModelConstants.COLUMN_ID)
    @OneToMany(mappedBy = ModelConstants.COLUMN_CATALOG, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @Column(name = ModelConstants.COLUMN_CATALOG_PRODUCTS)
    private Set<ProductModel> products;

    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = ModelConstants.COLUMN_ID)
    @OneToMany(mappedBy = ModelConstants.COLUMN_CATALOG, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @Column(name = ModelConstants.COLUMN_CATALOG_CATEGORIES)
    private Set<CategoryModel> categories;

}