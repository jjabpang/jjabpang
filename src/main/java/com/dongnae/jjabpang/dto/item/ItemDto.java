package com.dongnae.jjabpang.dto.item;
/*
 *packageName    : com.dongnae.jjabpang.entity
 * fileName       : ItemDto
 * author         : ipeac
 * date           : 2022-08-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-07        ipeac       최초 생성
 */

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ItemDto implements Serializable {
      private String cdt;
      private String udt;
      private Long itemNo;
      private String brandName;
      private String title;
      private String image;
      private Integer price;
      private float discountRate;
      private Integer deliveryFee;
      private Integer specialFee;
      private float ratingSum;
      private Integer ratingCnt;
      private String detail;
      private Integer quantity;
      
      @QueryProjection
      public ItemDto(String cdt, String udt, Long itemNo, String brandName, String title, String image, Integer price, float discountRate, Integer deliveryFee, Integer specialFee, float ratingSum, Integer ratingCnt, String detail, Integer quantity) {
            this.cdt = cdt;
            this.udt = udt;
            this.itemNo = itemNo;
            this.brandName = brandName;
            this.title = title;
            this.image = image;
            this.price = price;
            this.discountRate = discountRate;
            this.deliveryFee = deliveryFee;
            this.specialFee = specialFee;
            this.ratingSum = ratingSum;
            this.ratingCnt = ratingCnt;
            this.detail = detail;
            this.quantity = quantity;
            
      }
      
      
}
