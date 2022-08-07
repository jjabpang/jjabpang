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
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ItemCategoryOrNameResponseDto implements Serializable {
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
      public ItemCategoryOrNameResponseDto(Long itemNo, String title, String image, Integer price, float discountRate, Integer deliveryFee, Integer specialFee, float ratingSum, Integer ratingCnt) {
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
