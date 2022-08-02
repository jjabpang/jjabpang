package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 회원
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@ToString
@Table(name = "user")
@ApiModel("회원엔티티")
public class User {
      
      /**
       * 회원번호
       */
      @Id
      @Column(name = "user_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @ApiModelProperty(value = "유저번호", required = true)
      private Integer userNo;
      
      /**
       * 이메일
       */
      @Column(name = "email", length = 50)
      @ApiModelProperty(value = "이메일")
      private String email;
      
      /**
       * 비밀번호
       */
      @Column(name = "password", length = 500)
      @ApiModelProperty(value = "비밀번호")
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
      @Column(name = "agree_tos", columnDefinition = "varchar(5) default '0'")
      private String agreeTos;
      
      /**
       * 개인정보수집 및 이용동의
       */
      @Column(name = "agree_picu", columnDefinition = "varchar(5) default '0'")
      private String agreePicu;
      
      /**
       * 이벤트, 프로모션 메일, SMS수신
       */
      @Column(name = "agree_promotion", columnDefinition = "varchar(5) default '0'")
      private String agreePromotion;
      
      /**
       * 성별
       */
      @Column(name = "gender", columnDefinition = "varchar(5) default 'm'")
      private String gender;
      
      /**
       * 역할구분(구매자,판매자,관리자)
       */
      @Column(name = "role", columnDefinition = "varchar(20) default 'b'")
      @Enumerated(EnumType.STRING)
      private Role role;
      
      /**
       * 회원상태
       */
      @Column(name = "del_yn", columnDefinition = "varchar(5) default 'n'")
      private String delYn;
      
      /**
       * 가입일자
       */
      @Column(name = "cdt", updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
      private LocalDateTime cdt;
      
      /**
       * 회원정보수정일자
       */
      @Column(name = "udt", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
      private LocalDateTime udt;
      
      /**
       * 휴대폰 번호
       */
      @Column(name = "phone_nm", nullable = false)
      private String phoneNm;
      
}
