package com.crv.microstore.userservice.model;

import com.crv.microstore.userservice.config.UserConstants.ModelConstants;
import com.crv.microstore.userservice.model.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = ModelConstants.TABLE_EMPLOYEE)
@Data
public class EmployeeModel extends GenericModel <String>{

    @Column(name = ModelConstants.COLUMN_ROLE)
    private Roles role;
}
