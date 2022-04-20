package com.example.jpaExam.repository;

import com.example.jpaExam.domain.entity.Customers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomersRepository {
        @PersistenceContext  // 엔티티 매니저 주입
    private EntityManager em;
    public void save(Customers customers) {
        em.persist(customers);
    }
    public Customers findOne(Long id) {
        return em.find(Customers.class, id);
    }
    public List<Customers> findAll() {
        return em.createQuery("select m from Customers m", Customers.class)
                .getResultList();
    }
    public List<Customers> findByName(String name) {
        return em.createQuery("select m from Customers m where m.name = :name",
                        Customers.class)
                .setParameter("name", name)
                .getResultList();
    }
}


