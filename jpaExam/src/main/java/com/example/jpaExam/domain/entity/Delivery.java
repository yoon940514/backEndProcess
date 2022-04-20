package com.example.jpaExam.domain.entity;

import com.example.jpaExam.domain.status.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "DELIVERY")
public class Delivery {

    @Id // 기본키
    @GeneratedValue // 기본키 배열방식
    @Column(name = "DELIVERY_ID")
    private Long deliveryId;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  //  @Column(name = "ORDERS")
    private Orders orders;

    @Embedded
    private Address address;

    private LocalDateTime deliveryDate;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus; // 배송상태 READY, GO
}
