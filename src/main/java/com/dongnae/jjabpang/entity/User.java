package com.dongnae.jjabpang.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 회원
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "User")
public class User extends BaseTimeEntity implements Serializable {
      
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
      @Column(name = "email", length = 50)
      private String email;
      
      /**
       * 비밀번호
       */
      @Column(name = "password", length = 500)
      private String password;
      
      /**
       * 생년월일
       */
      @Column(name = "birth", length = 10)
      private String birth;
      
      /**
       * 닉네임
       */
      @Column(name = "nickname", length = 50)
      private String nickname;
      
      /**
       * 이용약관동의
       */
      @Column(name = "agree_TOS")
      private String agreeTos;
      
      /**
       * 개인정보수집 및 이용동의
       */
      @Column(name = "agree_PICU")
      private String agreePicu;
      
      /**
       * 이벤트, 프로모션 메일, SMS수신
       */
      @Column(name = "agree_promotion")
      private String agreePromotion;
      
      /**
       * 성별
       */
      @Column(name = "gender")
      private String gender;
      
      /**
       * 역할구분(구매자,판매자,관리자)
       */
      @Column(name = "role")
      @Enumerated(EnumType.STRING)
      private Role role;
      
      /**
       * 회원상태
       */
      @Column(name = "del_YN")
      private String delYn;
      
      /**
       * 가입일자
       */
      @Column(name = "cdt")
      private LocalDateTime cdt;
      
      /**
       * 회원정보수정일자
       */
      @Column(name = "udt")
      private LocalDateTime udt;
      
      /**
       * 휴대폰 번호
       */
      @Column(name = "phone_nm", nullable = false)
      private String phoneNm;
      
}
