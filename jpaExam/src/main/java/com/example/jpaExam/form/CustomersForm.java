package com.example.jpaExam.form;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CustomersForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")    // null 이면 오류가 뜨게 유효성 검사
    private String name;

    private String city;
    private String street;
    private String zipcode;

    private int phoneNumber;
    private String company;
}
