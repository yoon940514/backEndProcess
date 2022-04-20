package com.example.jpaExam.domain.entity.products;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Beverage")
@Getter
@Setter
public class Beverage extends Products{
    private String cock;
    private String cider;
}
