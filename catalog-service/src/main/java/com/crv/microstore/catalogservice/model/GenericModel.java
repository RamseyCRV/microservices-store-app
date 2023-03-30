package com.crv.microstore.catalogservice.model;

import com.crv.microstore.catalogservice.config.CatalogConstants.ModelConstants;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class GenericModel< U > implements Serializable {

    @CreatedBy
    @Column(updatable = false)
    protected U createdBy;

    @CreatedDate
    @Column(updatable = false)
    protected Date createdDate;

    @LastModifiedBy
    protected U lastModifiedBy;

    @LastModifiedDate
    protected Date lastModifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ModelConstants.COLUMN_ID, nullable = false)
    protected Long id;

    @Column(name = ModelConstants.COLUMN_NAME)
    protected String name;

    @Column(name = ModelConstants.COLUMN_DESCRIPTION)
    protected String description;

}
