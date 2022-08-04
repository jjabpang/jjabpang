package com.dongnae.jjabpang.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "order_item")
public class OrderItem extends BaseTimeEntity {
      @Id
      @Column(name = "order_item_no", nullable = false)
      private Long OrderItemNo;
      
      @Column(name = "quantity")
      private Integer quantity;
      
      @Column(name = "price")
      private Integer price;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "order_no")
      private Order order;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "item_no")
      private Item item;
      
      /*==생성 메서드==*/
      
}