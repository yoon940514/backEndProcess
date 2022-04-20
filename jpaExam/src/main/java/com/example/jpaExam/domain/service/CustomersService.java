package com.example.jpaExam.domain.service;

import com.example.jpaExam.domain.entity.Customers;
import com.example.jpaExam.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)     // 데이터의 변경이 없는 읽기 전용 메서드에 사용.
@RequiredArgsConstructor    // 필요 생성자 주입
public class CustomersService {
    private final CustomersRepository customersRepository;
    /*
     * 회원가입
     */
    @Transactional //변경
    public Long join(Customers customers) {
        validateDuplicateCustomers(customers); //중복 회원 검증 로직
        customersRepository.save(customers);
        return customers.getCustomersId();
    }
    private void validateDuplicateCustomers(Customers customers) {
        List<Customers> findCustomerss =
                customersRepository.findByName(customers.getName());
        if (!findCustomerss.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    /* 전체 회원 조회
     */
    public List<Customers> findcustomers() {
        return customersRepository.findAll();
    }
    // 회원 한명 조회
    public Customers findOne(Long CustomersId) {
        return customersRepository.findOne(CustomersId);
    }
}