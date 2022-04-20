package com.example.jpaExam.repository;

import com.example.jpaExam.domain.entity.products.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductsRepository {

    private final EntityManager em;
    public void save(Products products) {
        if (products.getProductsId() == null) {
            em.persist(products);
        } else {
            em.merge(products);
        }
    }
    public Products findOne(Long id) {
        return em.find(Products.class, id);
    }
    public List<Products> findAll() {
        return em.createQuery("select i from Products i",Products.class).getResultList();
    }
}

