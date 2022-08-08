package com.dongnae.jjabpang.dto;

import lombok.Getter;
import lombok.Setter;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : CartetailDto
 * author         : ipeac
 * date           : 2022-08-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-08        ipeac       최초 생성
 */
@Getter
@Setter
public class CartDetailDto {
      private Long cartItemNo; // 장바구니 상품 고유 번호
      private String itemTitle;
      private String itemImg;
      private int itemPrice;
      private int itemCount;
      private int deliveryfee;
      
      public CartDetailDto(Long cartItemNo, String itemTitle, String itemImg, int itemPrice, int itemCount, int deliveryfee) {
            this.cartItemNo = cartItemNo;
            this.itemTitle = itemTitle;
            this.itemImg = itemImg;
            this.itemPrice = itemPrice;
            this.itemCount = itemCount;
            this.deliveryfee = deliveryfee;
      }
}
