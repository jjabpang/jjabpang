package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "delivery")
@ApiModel("배송지 엔티티")
@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class Delivery extends BaseTimeEntity {
      
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "delivery_no", nullable = false)
      @ApiModelProperty(name = "배송지 번호")
      private Long deliveryNo;
      
      @ApiModelProperty(name = "배송지명")
      @Column(name = "delivery_name", columnDefinition = "VARCHAR(20)")
      private String deliveryName;
      
      @ApiModelProperty(name = "받는 사람")
      @Column(name = "receiver", columnDefinition = "VARCHAR(20)")
      private String receiver;
      
      @ApiModelProperty(name = "연락처")
      @Column(name = "phone_number", columnDefinition = "CHAR(13)")
      private String phoneNumber;
      
      @ApiModelProperty(name = "주소1")
      @Column(name = "address1", columnDefinition = "VARCHAR(50)")
      private String address1;
      
      @ApiModelProperty(name = "주소2")
      @Column(name = "address2", columnDefinition = "VARCHAR(50)")
      private String address2;
      
      @ApiModelProperty(name = "기본 배송지 여부")
      @Column(name = "default_delivery", columnDefinition = "CHAR(3) DEFAULT 'Y' ")
      private String defaultDelivery;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "user_no")
      @ApiModelProperty(name = "회원")
      @ToString.Exclude
      private User user;
      
      @OneToOne(fetch = LAZY, mappedBy = "delivery")
      @ApiModelProperty(name = "주문")
      @ToString.Exclude
      private Order order;
      
      public static Delivery createDelivery(User user, String address1, String address2, String defaultDelivery, String deliveryName, String receiver, String phoneNumber) {
            Delivery delivery = new Delivery();
            delivery.setUser(user);
            delivery.setAddress1(address1);
            delivery.setAddress2(address2);
            delivery.setDefaultDelivery(defaultDelivery);
            delivery.setDeliveryName(deliveryName);
            delivery.setReceiver(receiver);
            delivery.setPhoneNumber(phoneNumber);
            
            return delivery;
      }
}