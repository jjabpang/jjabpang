package com.dongnae.jjabpang.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.dongnae.jjabpang.dto
 * fileName       : JjimListResponseDto
 * author         : jihye94
 * date           : 2022-08-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-14        jihye94       최초 생성
 */
@Data
@ApiModel(description = "찜리스트 응답 DTO")
@NoArgsConstructor()
public class JjimListResponseDto {
      @ApiModelProperty(name = "상품 제목")
      private String itemTitle;
      @ApiModelProperty(name = "상품 가격")
      private Integer itemPrice;
      @ApiModelProperty(name = "상품 이미지")
      private String itemImg;
      @ApiModelProperty(name = "배송비")
      private Integer deliveryFee;
      
      @QueryProjection
      public JjimListResponseDto(String itemTitle, Integer itemPrice, String itemImg, Integer deliveryFee) {
            this.itemTitle = itemTitle;
            this.itemPrice = itemPrice;
            this.itemImg = itemImg;
            this.deliveryFee = deliveryFee;
      }
}
