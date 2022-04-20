package com.example.jpaExam.controller;

import com.example.jpaExam.domain.entity.products.Food;
import com.example.jpaExam.domain.entity.products.Products;
import com.example.jpaExam.domain.service.ProductsService;
import com.example.jpaExam.form.FoodForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping(value = "/product/new")
    public String createForm(Model model) {
        model.addAttribute("form", new FoodForm());
        return "products/createProductsForm";
    }
    @PostMapping(value = "/product/new")
    public String create(FoodForm foodForm) {
        Food food = new Food();
        food.setName(foodForm.getName());
        food.setPrice(foodForm.getPrice());
        food.setStock(foodForm.getStock());
        food.setPizza(foodForm.getPizza());
        food.setBurger(foodForm.getBurger());
        productsService.saveproducts(food);
        return "redirect:/products";
    }

    @GetMapping(value = "/products")
    public String list(Model model) {
        List<Products> findproducts = productsService.findproducts();
        model.addAttribute("findproducts", findproducts);
        return "products/productList";
    }

    @GetMapping(value = "/customers/{customersId}/edit")
    public String updateItemForm(@PathVariable("customersId") Long productId, Model
            model) {
        Food item = (Food) productsService.findOne(productId);
        FoodForm form = new FoodForm();
        form.setProductsId(item.getProductsId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStock(item.getStock());
        form.setBurger(item.getBurger());
        form.setPizza(item.getPizza());
        model.addAttribute("form", form);
        return "products/updateProductForm";
    }
    /**
     * 상품 수정
     */
    @PostMapping(value = "/customers/{customersId}/edit")
    public String updateItem(@ModelAttribute("form") FoodForm foodForm) {
        Food food = new Food();
        food.setProductsId(foodForm.getProductsId());
        food.setName(foodForm.getName());
        food.setPrice(foodForm.getPrice());
        food.setStock(foodForm.getStock());
        food.setPizza(foodForm.getPizza());
        food.setBurger(foodForm.getBurger());

        productsService.saveproducts(food);
        return "redirect:/products";
    }
    }

