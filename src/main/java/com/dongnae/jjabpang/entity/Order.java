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
@Table(name = "orders")
@ApiModel("주문엔티티")
public class Order extends BaseTimeEntity {
      @Id
      @Column(name = "order_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @ApiModelProperty(name = "주문 번호", required = true)
      private Long orderNo;
      
      @ApiModelProperty(name = "상품 개수")
      @Column(name = "quantity", columnDefinition = "INT DEFAULT 0")
      private Integer quantity;
      
      @Enumerated(EnumType.STRING)
      @Column(name = "status", columnDefinition = "VARCHAR(10)")
      @ApiModelProperty(name = "상품 상태")
      private Status status;
      
      @Column(name = "memo", length = 100, columnDefinition = "VARCHAR(300)")
      @ApiModelProperty(name = "상품 메모")
      private String memo;
      
      
}
