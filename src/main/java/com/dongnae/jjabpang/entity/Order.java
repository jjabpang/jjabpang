package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

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
@Table()
@ApiModel("주문엔티티")
public class Order extends BaseTimeEntity {
      @Id
      @Column(name = "order_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @ApiModelProperty(name = "주문 번호", required = true)
      private Long orderNo;
      
      @ApiModelProperty(name = "상품 개수")
      @Column(name = "quantity")
      private Integer quantity;
      
      @Enumerated(EnumType.STRING)
      @Column(name = "status")
      private Status status;
      
      @Column(name = "memo", length = 100)
      private String memo;
      
      
}
