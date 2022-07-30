package com.dongnae.jjabpang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 장바구니
 */
@Data
@Entity
@Table(name = "cart")
public class Cart implements Serializable {
      
      private static final long serialVersionUID = 1L;
      
      /**
       * 장바구니 번호
       */
      @Id
      @Column(name = "cart_no", nullable = false)
      private Integer cartNo;
      
      /**
       * 회원번호
       */
      @Id
      @Column(name = "user_no", nullable = false)
      private Integer userNo;
      
      /**
       * 상품번호
       */
      @Id
      @Column(name = "item_no", nullable = false)
      private Integer itemNo;
      
}
