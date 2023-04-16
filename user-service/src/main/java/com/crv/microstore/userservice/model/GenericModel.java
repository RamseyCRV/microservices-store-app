package com.crv.microstore.userservice.model;

import com.crv.microstore.userservice.config.UserConstants.ModelConstants;
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

    @Column(name = ModelConstants.COLUMN_FIRST_NAME)
    protected String firstName;

    @Column(name = ModelConstants.COLUMN_LAST_NAME)
    protected String lastName;

    @Column(name = ModelConstants.COLUMN_DESCRIPTION)
    protected String description;

    @Column(name = ModelConstants.COLUM_EMAIL)
    protected String email;

    @Column(name = ModelConstants.COLUMN_PASSWORD)
    protected String password;
}
