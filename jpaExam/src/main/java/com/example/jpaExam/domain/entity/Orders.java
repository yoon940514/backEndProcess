package com.example.jpaExam.domain.entity;

import com.example.jpaExam.domain.status.DeliveryStatus;
import com.example.jpaExam.domain.status.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Orders {

    @Id // 기본키
    @GeneratedValue // 기본키 배열방식
    @Column(name = "ORDERS_ID")
    private Long ordersId;

    @ManyToOne(fetch = FetchType.LAZY)  // 지연 로딩
    @JoinColumn(name = "CUSTOMERS_ID")
    private Customers customers;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrdersProducts> ordersProductsListByOrders = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;


    private LocalDateTime ordersDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문상태 ORDER, CANCEL

    // 연관관계 메서드
    public void setCustomers(Customers customers) {
        this.customers = customers;
        customers.getOrdersList().add(this);
    }

    public void setOrdersProducts (OrdersProducts ordersProducts) {
        ordersProductsListByOrders.add(ordersProducts);
        ordersProducts.setOrders(this);
    }

    public void setDelivery (Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrders(this);
    }

    // 생성 메서드
    public static Orders createOrder(Customers customers, Delivery delivery,
                                    OrdersProducts... ordersProductsListByOrders) {
        Orders orders = new Orders();
        orders.setCustomers(customers);
        orders.setDelivery(delivery);
        for (OrdersProducts ordersProduct : ordersProductsListByOrders) {
            orders.setOrdersProducts(ordersProduct);
        }
        orders.setOrderStatus(OrderStatus.ORDER);
        orders.setOrdersDate(LocalDateTime.now());
        return orders;
    }

    // 비즈니스 로직 메서드
    // 1. 주문 취소
    public void cancel() {
        if (delivery.getDeliveryStatus() == DeliveryStatus.GO) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }
        this.setOrderStatus(OrderStatus.CANCEL);
        for (OrdersProducts ordersProduct : ordersProductsListByOrders) {
            ordersProduct.cancel();
        }
    }

    // 2. 전체 주문가격 조회
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrdersProducts ordersProduct : ordersProductsListByOrders) {
            totalPrice += ordersProduct.getTotalPrice();
        }
        return totalPrice;
    }

}
