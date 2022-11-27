package com.techsupport.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long typeId;

    @Column(unique = true)
    private String type;

    @OneToMany(mappedBy = "deviceId", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("type")
    private List<Device> devices;

    public Type() {
    }
}
