package com.example.jpaExam.domain.dyQuery;

import com.example.jpaExam.domain.status.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;

}
