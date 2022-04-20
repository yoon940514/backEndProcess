package com.example.jpaExam.domain.service;

import com.example.jpaExam.domain.dyQuery.OrderSearch;
import com.example.jpaExam.domain.entity.Customers;
import com.example.jpaExam.domain.entity.Delivery;
import com.example.jpaExam.domain.entity.Orders;
import com.example.jpaExam.domain.entity.OrdersProducts;
import com.example.jpaExam.domain.entity.products.Products;
import com.example.jpaExam.domain.status.DeliveryStatus;
import com.example.jpaExam.repository.CustomersRepository;
import com.example.jpaExam.repository.OrdersRepository;
import com.example.jpaExam.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrdersService {
    private final CustomersRepository customersRepository;
    private final OrdersRepository ordersRepository;
    private final ProductsRepository productsRepository;
    /** 주문 */
    @Transactional
    public Long order(Long CustomersId, Long ProductsId, int count) {
        //엔티티 조회
        Customers Customers = customersRepository.findOne(CustomersId);
        Products Products = productsRepository.findOne(ProductsId);
        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(Customers.getAddress());
        delivery.setDeliveryStatus(DeliveryStatus.READY);
        //주문상품 생성
        OrdersProducts ordersProducts = OrdersProducts.createOrdersProducts(Products, Products.getPrice(), count);
        //주문 생성
        Orders order = Orders.createOrder(Customers, delivery, ordersProducts);
        //주문 저장
        ordersRepository.save(order);
        return order.getOrdersId();
    }
    /* 주문 취소 */
    @Transactional
    public void cancelOrder(Long orderId) {
        //주문 엔티티 조회
        Orders order = ordersRepository.findOne(orderId);
        //주문 취소
        order.cancel();
    }
    /* 주문 검색 */

 public List<Orders> findOrders(OrderSearch orderSearch) {
    return ordersRepository.findAllByString(orderSearch);
 }

}