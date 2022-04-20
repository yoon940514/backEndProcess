package com.example.jpaExam.domain.service;

import com.example.jpaExam.domain.entity.products.Products;
import com.example.jpaExam.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductsService {

        private final ProductsRepository productsRepository;

        @Transactional
        public void saveproducts(Products products) {
            productsRepository.save(products);
        }
        public List<Products> findproducts() {
            return productsRepository.findAll();
        }
        public Products findOne(Long productsId) {
            return productsRepository.findOne(productsId);
        }


    }


