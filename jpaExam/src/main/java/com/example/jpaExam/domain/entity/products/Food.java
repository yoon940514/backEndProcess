package com.example.jpaExam.domain.entity.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Food")
@Getter
@Setter
public class Food extends Products{
    private String pizza;
    private String burger;
}
