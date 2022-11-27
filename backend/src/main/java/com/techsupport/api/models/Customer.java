package com.techsupport.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Customer extends Person{

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private List<CustomerProduct> customerProductList;

}
