package com.crv.microstore.userservice.model;

import com.crv.microstore.userservice.config.UserConstants.ModelConstants;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = ModelConstants.TABLE_CUSTOMERS)
@Data
public class CustomerModel extends GenericModel < String >{


}
