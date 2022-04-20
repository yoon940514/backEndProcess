package com.example.jpaExam.domain.entity.products;

import com.example.jpaExam.domain.entity.OrdersProducts;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Products {

    @Id
    @GeneratedValue
    @Column(name = "PRODUCTS_ID")
    private Long productsId;

    private String name;

    private int price;

    private int stock;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<OrdersProducts> ordersProductsListByProducts = new ArrayList<>();

    // 비즈니스 로직

    // 1. 재고를 하나씩 더하는 로직
    public void addStock(int stock) {
        this.stock += stock;
    }

    // 2. 재고를 하나씩 빼는 로직
    public void removeStock(int stockArg) {
        int restStock = this.stock - stockArg;
        if (restStock < 0) {
            throw new NotEnoughStockException("재고가 더 필요합니다!");
        }
        this.stock = restStock;
    }
}


