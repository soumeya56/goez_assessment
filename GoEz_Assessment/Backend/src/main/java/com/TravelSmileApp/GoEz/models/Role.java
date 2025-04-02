package com.TravelSmileApp.GoEz.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }


    public void setName(ERole name) {
        this.name = name;
    }


    public ERole getName() {
        return name;
    }

    public Role(ERole name) {
        this.name = name;
    }


}