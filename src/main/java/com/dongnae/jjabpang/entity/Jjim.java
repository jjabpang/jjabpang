package com.dongnae.jjabpang.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : Jjim
 * author         : jihye94
 * date           : 2022-08-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-13        jihye94       최초 생성
 */
@Entity(name = "Jjim")
@Getter
@Setter
public class Jjim extends BaseTimeEntity {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "jjim_no", nullable = false)
      private Long jjimNo;
      
      /**
       * 회원 번호
       */
      @JoinColumn(name = "user_no")
      @OneToOne(fetch = LAZY)
      private User user;
      
      /**
       * 찜 번호
       */
      @OneToMany(fetch = LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
      @JoinColumn(name = "jjim_no")
      private List<JjimItem> jjimItems = new ArrayList<>();
      
}
