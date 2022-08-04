package com.dongnae.jjabpang.entity.dto;
/*
 *packageName    : com.dongnae.jjabpang.entity
 * fileName       : ItemCategoryAndNameRequestDto
 * author         : ipeac
 * date           : 2022-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-04        ipeac       최초 생성
 */

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ItemCategoryOrNameRequestDto implements Serializable {
      private final LocalDateTime cdt;
      private final LocalDateTime udt;
      private final Long itemNo;
      private final String title;
      private final String image;
      private final Integer price;
      private final float discountRate;
      private final Integer deliveryFee;
      private final Integer specialFee;
      private final float ratingSum;
      private final Integer ratingCnt;
      
      @QueryProjection
      public ItemCategoryOrNameRequestDto(LocalDateTime cdt, LocalDateTime udt, Long itemNo, String title, String image, Integer price, float discountRate, Integer deliveryFee, Integer specialFee, float ratingSum, Integer ratingCnt) {
            this.cdt = cdt;
            this.udt = udt;
            this.itemNo = itemNo;
            this.title = title;
            this.image = image;
            this.price = price;
            this.discountRate = discountRate;
            this.deliveryFee = deliveryFee;
            this.specialFee = specialFee;
            this.ratingSum = ratingSum;
            this.ratingCnt = ratingCnt;
      }
}
