package com.example.jpaExam.domain.service;

import com.example.jpaExam.domain.entity.Address;
import com.example.jpaExam.domain.entity.Customers;
import com.example.jpaExam.domain.entity.Orders;
import com.example.jpaExam.domain.entity.products.Food;
import com.example.jpaExam.domain.entity.products.NotEnoughStockException;
import com.example.jpaExam.domain.entity.products.Products;
import com.example.jpaExam.domain.status.OrderStatus;
import com.example.jpaExam.repository.OrdersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrdersServiceTest {

    @PersistenceContext EntityManager em;
    @Autowired OrdersService ordersService;
    @Autowired
    OrdersRepository ordersRepository;

    @Test
    public void Order() throws Exception {
        //Given
        Customers customers = createCustomers();
        Products products = createFood("피자", 10000, 10); //이름, 가격, 재고
        int orderCount = 2;
        //When
        Long orderId = ordersService.order(customers.getCustomersId(), products.getProductsId(),
                orderCount);
        //Then
        Orders getOrder = ordersRepository.findOne(orderId);
        assertEquals("상품 주문시 상태는 ORDER인가?", OrderStatus.ORDER,
                getOrder.getOrderStatus());
        assertEquals("주문한 상품 종류 수가 일치하는가?",1,
                getOrder.getOrdersProductsListByOrders().size());
        assertEquals("주문 가격은 가격 * 수량인가?", 10000 * 2,
                getOrder.getTotalPrice());
        assertEquals("주문 수량만큼 재고가 줄어드는가?",8, products.getStock());
    }
    @Test(expected = NotEnoughStockException.class)
    public void 재고수량초과() throws Exception {
        //Given
        Customers customers = createCustomers();
        Products products = createFood("피자", 10000, 10); //이름, 가격, 재고
        int orderCount = 11; //재고보다 많은 수량
        //When
        ordersService.order(customers.getCustomersId(), products.getProductsId(), orderCount);
        //Then
        fail("재고 수량 부족");
    }
    @Test
    public void cancel() {
        Customers customers = createCustomers();
        Products products = createFood("버거", 10000, 10);

        int orderCount = 2;

        Long orderId = ordersService.order(customers.getCustomersId(), products.getProductsId(),
                orderCount);
        //When
        ordersService.cancelOrder(orderId);
        //Then
        Orders getOrder = ordersRepository.findOne(orderId);
        assertEquals("주문 취소시 상태는 CANCEL 이다.",OrderStatus.CANCEL,
                getOrder.getOrderStatus());
        assertEquals("주문이 취소된 상품은 재고가 원상복구 된다.", 10,
                products.getStock());
    }

    private Customers createCustomers() {
        Customers customers = new Customers();
        customers.setName("회원1");
        customers.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(customers);
        return customers;
    }
    private Food createFood(String name, int price, int stock) {
        Food food = new Food();
        food.setName(name);
        food.setStock(stock);
        food.setPrice(price);
        em.persist(food);
        return food;
    }
}