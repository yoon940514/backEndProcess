package com.example.jpaExam.domain.entity;

import com.example.jpaExam.domain.entity.products.Products;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS_PRODUCTS")
@Getter
@Setter
public class OrdersProducts {

    @Id
    @GeneratedValue
    @Column(name = "ORDERSPRODUCTS_ID")
    private Long OrdersProductsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "ORDERS_ID")
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "PRODUCTS_ID")
    private Products products;

    private int orderPrice;

    private int count;

    // 생성 메서드
    public static OrdersProducts createOrdersProducts(Products products, int orderPrice, int
            count) {
        OrdersProducts ordersProducts = new OrdersProducts();
        ordersProducts.setProducts(products);
        ordersProducts.setOrderPrice(orderPrice);
        ordersProducts.setCount(count);

        products.removeStock(count);
        return ordersProducts;
    }
    // 비즈니스 로직
    // 1. 주문 취소
    public void cancel() {
        getProducts().addStock(count);
    }
    // 2. 주문상풍 전체 가격 조회
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
