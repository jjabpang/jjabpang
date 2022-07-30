package com.dongnae.jjabpang.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 주문
 */
@Data
@Entity
@Table(name = "order")
public class Order implements Serializable {
      
      private static final long serialVersionUID = 1L;
      
      /**
       * 주문번호
       */
      @Id
      @Column(name = "order_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer orderNo;
      
      /**
       * 상품번호
       */
      @Id
      @Column(name = "item_no", nullable = false)
      private Integer itemNo;
      
      /**
       * 회원번호
       */
      @Id
      @Column(name = "user_no", nullable = false)
      private Integer userNo;
      
}
