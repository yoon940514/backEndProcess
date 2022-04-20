package com.example.jpaExam.domain.entity.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Condiment")
@Getter
@Setter
public class Condiment extends Products{
    private String suger;
    private String soy;
}
