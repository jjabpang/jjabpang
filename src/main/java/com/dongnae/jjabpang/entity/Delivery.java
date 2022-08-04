package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@ApiModel("배송지 엔티티")
public class Delivery extends BaseTimeEntity {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "delivery_no", nullable = false)
      @ApiModelProperty(name = "배송지 번호")
      private Long deliveryNo;
      
      
}