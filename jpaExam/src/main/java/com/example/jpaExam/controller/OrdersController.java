package com.example.jpaExam.controller;

import com.example.jpaExam.domain.dyQuery.OrderSearch;
import com.example.jpaExam.domain.entity.Customers;
import com.example.jpaExam.domain.entity.Orders;
import com.example.jpaExam.domain.entity.products.Products;
import com.example.jpaExam.domain.service.CustomersService;
import com.example.jpaExam.domain.service.OrdersService;
import com.example.jpaExam.domain.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService orderService;
    private final CustomersService memberService;
    private final ProductsService productsService;

    @GetMapping(value = "/order")
    public String createForm(Model model) {
        List<Customers> customers = memberService.findcustomers();
        List<Products> products = productsService.findproducts();

        model.addAttribute("customers", customers);
        model.addAttribute("products", products);
        return "orders/orderForm";
    }

    @PostMapping(value = "/order")
    public String order(@RequestParam("customersId") Long memberId,
                        @RequestParam("productsId") Long itemId, @RequestParam("count") int count) {
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping(value = "/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
        List<Orders> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "orders/orderList";
    }

    @PostMapping(value = "/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}

