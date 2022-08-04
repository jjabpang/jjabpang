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
      public static OrderItem createOrderItem(Item item, int price, int quantity) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setPrice(price);
            orderItem.setQuantity(quantity);
            
            item.removeStock(quantity);
            return orderItem;
      }
      
      /*==비즈니스 로직==*/
      
      /**
       * 주문 취소
       */
      public void cancle() {
            getItem().addStock(quantity);
      }
      
      /*==조회 로직 ==*/
      
      /**
       * 주문 상품 전체 가격 조회
       */
      public int getTotalPrice() {
            return quantity * price;
      }
      
}