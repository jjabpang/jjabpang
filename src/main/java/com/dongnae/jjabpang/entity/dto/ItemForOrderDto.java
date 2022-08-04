package com.dongnae.jjabpang.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * packageName    : com.dongnae.jjabpang.entity.dto
 * fileName       : ItemForOrderDto
 * author         : jihye94
 * date           : 2022-08-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-05        jihye94       최초 생성
 */
@Data
public class ItemForOrderDto implements Serializable {
      private final Long itemNo;
      private final String title;
      private final String image;
      private final Integer price;
      private final float discountRate;
      private final Integer deliveryFee;
      private final Integer specialFee;
      private final String detail;
      private final Integer quantity;
}
