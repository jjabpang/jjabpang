package com.dongnae.jjabpang.entity;

import lombok.*;

import javax.persistence.*;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : Item
 * author         : jihye94
 * date           : 2022-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-03        jihye94       최초 생성
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "item")
public class Item extends BaseTimeEntity {
      @Id
      @Column(name = "item_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long itemNo;
}
