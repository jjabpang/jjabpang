package com.dongnae.jjabpang.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 판매자
 */
@Data
@Entity
@Table(name = "seller")
public class Seller implements Serializable {
      
      private static final long serialVersionUID = 1L;
      
      /**
       * 판매자 번호
       */
      @Id
      @Column(name = "seller_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer sellerNo;
      
      /**
       * 회원번호
       */
      @Column(name = "user_no")
      private Integer userNo;
      
      /**
       * 회사이름
       */
      @Column(name = "company_name")
      private String companyName;
      
      /**
       * 대표자이름
       */
      @Column(name = "president_name")
      private String presidentName;
      
      /**
       * 사업장소재지
       */
      @Column(name = "company_location")
      private String companyLocation;
      
      /**
       * 회사 이메일
       */
      @Column(name = "company_email")
      private String companyEmail;
      
      /**
       * 사업자등록번호
       */
      @Column(name = "seller_reg_num")
      private BigDecimal sellerRegNum;
      
}
