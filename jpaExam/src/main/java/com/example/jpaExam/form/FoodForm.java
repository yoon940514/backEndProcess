package com.example.jpaExam.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodForm {

    private Long productsId;
    private String name;
    private int price;
    private int stock;

    private String pizza;
    private String burger;
}
