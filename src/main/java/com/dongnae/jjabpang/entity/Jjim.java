package com.dongnae.jjabpang.entity;

import lombok.*;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Jjim extends BaseTimeEntity {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "jjim_no", nullable = false)
      private Long jjimNo;
      
      /**
       * 회원 번호
       */
      @JoinColumn(name = "user_no", columnDefinition = "BIGINT")
      @OneToOne(fetch = LAZY)
      @ToString.Exclude
      private User user;
      
      /**
       * 찜 번호
       */
      @OneToMany(fetch = LAZY, mappedBy = "jjim")
      @ToString.Exclude
      private List<JjimItem> jjimItems = new ArrayList<>();
      
      /**
       * 연관관계 메서드
       */
      public static Jjim createJjim(User user, List<JjimItem> jjimItems) {
            Jjim jjim = new Jjim();
            jjim.setJjimItems(jjimItems);
            jjim.setUser(user);
            return jjim;
      }
      
      
}
