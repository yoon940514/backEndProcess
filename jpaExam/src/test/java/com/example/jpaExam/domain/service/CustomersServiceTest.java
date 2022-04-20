package com.example.jpaExam.domain.service;

import com.example.jpaExam.domain.entity.Customers;
import com.example.jpaExam.repository.CustomersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomersServiceTest {
    @Autowired
    CustomersService CustomersService;
    @Autowired
    CustomersRepository customersRepository;
    @Test
    public void joinTest() throws Exception {
        //Given
        Customers customers = new Customers();
        customers.setName("kim");
        //When
        Long saveId = CustomersService.join(customers);
        //Then
        assertEquals(customers, customersRepository.findOne(saveId));
    }
    @Test
    public void validateDuplicateCustomers() throws Exception {
        String name = "1hon";

        Customers memberA = new Customers();
        memberA.setName(name);

        Customers memberB = new Customers();
        memberB.setName(name);

        //when
        CustomersService.join(memberA);

        //then
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> CustomersService.join(memberB));
        assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
}}