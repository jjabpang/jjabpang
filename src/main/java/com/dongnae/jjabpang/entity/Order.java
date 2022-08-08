package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : Order
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
@ToString
@Entity(name = "orders")
@Table(name = "orders")
@ApiModel("주문엔티티")
public class Order extends BaseTimeEntity {
      @Id
      @Column(name = "order_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @ApiModelProperty(name = "주문 번호", required = true)
      private Long orderNo;
      
      @Enumerated(EnumType.STRING)
      @Column(name = "status", columnDefinition = "VARCHAR(10)")
      @ApiModelProperty(name = "상품 상태")
      private Status status;
      
      @Column(name = "memo", length = 100, columnDefinition = "VARCHAR(300)")
      @ApiModelProperty(name = "상품 메모")
      private String memo;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "user_no")
      @ApiModelProperty(name = "회원번호")
      private User user;
      
      @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
      @JoinColumn(name = "delivery_no")
      private Delivery delivery;
      
      @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
      private List<OrderItem> orderItems = new ArrayList<>();
      
      /*연관관계*/
      public void setUser(User user) {
            this.user = user;
            user.getOrderList()
                .add(this);
      }
      
      public void addOrderItem(OrderItem orderItem) {
            
            orderItems.add(orderItem);
            orderItem.setOrder(this);
      }
      
      public void setDelivery(Delivery delivery) {
            this.delivery = delivery;
            delivery.setOrder(this);
      }
      
      /*==생성 메서드==*/
      public static Order createOrder(User user, Delivery delivery, OrderItem... orderItems) {
            Order order = new Order();
            order.setUser(user);
            order.setDelivery(delivery);
            
            for (OrderItem orderItem : orderItems) {
                  order.addOrderItem(orderItem);
            }
            
            order.setStatus(Status.ORDER);
            
            return order;
      }
      /*==비즈니스 로직==*/
      
      /**
       * 주문취소
       */
      public void cancel() {
            //
            if (status == Status.COMP) {
                  throw new IllegalStateException("이미 배송된 상품은 취소가 불가능합니다.");
            }
            
            this.setStatus(Status.CANCEL);
            for (OrderItem orderItem : orderItems) {
                  orderItem.cancle();
            }
            
      }
      
      /*==조회 로직 ==*/
      
      /**
       * 전체 주문 가격 조회
       */
      public int getTotalPrice() {
            int totalPrice = 0;
            
            for (OrderItem orderItem : orderItems) {
                  totalPrice += orderItem.getTotalPrice();
            }
            return totalPrice;
      }
}
