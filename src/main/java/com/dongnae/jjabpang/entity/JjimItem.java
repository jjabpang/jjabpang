package com.dongnae.jjabpang.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : JjimItem
 * author         : jihye94
 * date           : 2022-08-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-13        jihye94       최초 생성
 */
@Entity(name = "Jjim_item")
@Getter
@Setter
@ToString
public class JjimItem extends BaseTimeEntity {
      
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "jjim_item_no")
      private Long jjimItemNo;
      
      /**
       * 찜 번호
       */
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "jjim_no")
      @ToString.Exclude
      private Jjim jjim;
      
      /**
       * 상품 번호
       */
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "item_no")
      @ToString.Exclude
      private Item item;
}
