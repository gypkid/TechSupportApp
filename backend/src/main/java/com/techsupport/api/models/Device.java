package com.techsupport.api.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deviceId;

    private String model;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("devices")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "typeId")
    @JsonIgnoreProperties("devices")
    private Category type;

    @OneToMany(mappedBy = "device", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("device")
    private List<CustomerProduct> customerProductList;

    public Device() {
    }

}
