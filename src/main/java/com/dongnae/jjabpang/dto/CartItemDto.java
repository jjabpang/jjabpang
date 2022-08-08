package com.dongnae.jjabpang.dto;
/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : CartItemDto
 * author         : ipeac
 * date           : 2022-08-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-08        ipeac       최초 생성
 */

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CartItemDto implements Serializable {
      @NotNull(message = "상품 아이디는 필수 입력 값입니다.")
      private Long itemNo;
      @Min(value = 1, message = "최소 1개 이상을 담아주세요")
      private int itemCount;
      private int itemPrice;
      private String userEmail;
}
