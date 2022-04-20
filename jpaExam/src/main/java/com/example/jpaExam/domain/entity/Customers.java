package com.example.jpaExam.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMERS_ID")
    private Long customersId;

    private String name;

    private int phoneNumber;

    private String company;

    @Embedded
    Address address;

    @OneToMany(mappedBy = "customers")
    private List<Orders> ordersList = new ArrayList<>();
}
