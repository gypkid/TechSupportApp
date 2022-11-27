package com.techsupport.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    private String street;
    private String number;
    private String zipcode;
    private String city;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("address")
    private List<Person> persons;

    public Address(){}

    public Address(String street, String number, String zipcode, String city) {
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.city = city;
    }

}
