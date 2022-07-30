package com.dongnae.jjabpang.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 회원
 */
@Data
@Entity
@Table(name = "User")
public class User implements Serializable {
      
      private static final long serialVersionUID = 1L;
      
      /**
       * 회원번호
       */
      @Id
      @Column(name = "user_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer userNo;
      
      /**
       * 이메일
       */
      @Column(name = "email")
      private String email;
      
      /**
       * 비밀번호
       */
      @Column(name = "password")
      private String password;
      
      /**
       * 생년월일
       */
      @Column(name = "birth")
      private String birth;
      
      /**
       * 닉네임
       */
      @Column(name = "nickname")
      private String nickname;
      
      /**
       * 이용약관동의
       */
      @Column(name = "agree_TOS")
      private BigDecimal agreeTos;
      
      /**
       * 개인정보수집 및 이용동의
       */
      @Column(name = "agree_PICU")
      private BigDecimal agreePicu;
      
      /**
       * 이벤트, 프로모션 메일, SMS수신
       */
      @Column(name = "agree_promotion")
      private BigDecimal agreePromotion;
      
      /**
       * 성별
       */
      @Column(name = "gender")
      private BigDecimal gender;
      
      /**
       * 역할구분(구매자,판매자,관리자)
       */
      @Column(name = "role")
      private BigDecimal role;
      
      /**
       * 회원상태
       */
      @Column(name = "del_YN")
      private String delYn;
      
      /**
       * 가입일자
       */
      @Column(name = "cdt")
      private Date cdt;
      
      /**
       * 회원정보수정일자
       */
      @Column(name = "udt")
      private Date udt;
      
}
