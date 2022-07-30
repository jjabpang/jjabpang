package com.dongnae.jjabpang.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 상품
 */
@Data
@Entity
@Table(name = "Item")
public class Item implements Serializable {
      
      private static final long serialVersionUID = 1L;
      
      /**
       * 상품번호
       */
      @Id
      @Column(name = "item_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer itemNo;
      
      /**
       * 판매자 번호
       */
      @Column(name = "seller_no")
      private Integer sellerNo;
      
      /**
       * 카테고리 번호
       */
      @Column(name = "category_no")
      private Integer categoryNo;
      
      /**
       * 브랜드명
       */
      @Column(name = "brand_name")
      private String brandName;
      
      /**
       * 제목
       */
      @Column(name = "title")
      private String title;
      
      /**
       * 대표이미지
       */
      @Column(name = "image")
      private String image;
      
      /**
       * 가격
       */
      @Column(name = "price")
      private Integer price;
      
      /**
       * 할인율
       */
      @Column(name = "discount_rate")
      private BigDecimal discountRate;
      
      /**
       * 배송비
       */
      @Column(name = "delivery_fee")
      private Integer deliveryFee;
      
      /**
       * 특가
       */
      @Column(name = "special_price")
      private Integer specialPrice;
      
      /**
       * 생성일
       */
      @Column(name = "cdt")
      private Date cdt;
      
      /**
       * 수정일
       */
      @Column(name = "udt")
      private Date udt;
      
      /**
       * 별점 합
       */
      @Column(name = "rating_sum")
      private Integer ratingSum;
      
      /**
       * 별점 개수
       */
      @Column(name = "rating_cnt")
      private Integer ratingCnt;
      
      /**
       * 상품디테일
       */
      @Column(name = "detail")
      private String detail;
      
}
