package com.dongnae.jjabpang.dto.cart;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class CartDetailDto {
      private Long cartItemNo; // 장바구니 상품 고유 번호
      private String itemTitle;
      private String itemImg;
      private int itemPrice;
      private int itemCount;
      private int deliveryfee;
      
      
}
