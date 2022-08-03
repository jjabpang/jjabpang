package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : CartItem
 * author         : jihye94
 * date           : 2022-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-03        jihye94       최초 생성
 */
@Entity
@Table(name = "cart_item")
@Getter
@Setter
@ToString
@ApiModel("장바구니_상품_엔티티(다대다)")
public class CartItem extends BaseTimeEntity {
      @Id
      @ApiModelProperty(name = "장바구니_상품_번호")
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "cart_item_no", nullable = false)
      private Long cartItemNo;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "item")
      @ApiModelProperty(name = "상품")
      @ToString.Exclude
      private Item item;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "cart")
      @ApiModelProperty(name = "장바구니")
      @ToString.Exclude
      private Cart cart;
      
      @ApiModelProperty(name = "장바구니 안의 아이템의 개수")
      private int cartItemCount;
}
