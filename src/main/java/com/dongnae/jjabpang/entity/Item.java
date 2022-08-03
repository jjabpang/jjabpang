package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : Item
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
@Entity
@Table(name = "item")
@ApiModel("상품엔티티")
public class Item extends BaseTimeEntity {
      @Id
      @Column(name = "item_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @ApiModelProperty(name = "상품 번호", required = true)
      private Long itemNo;
      
      @ApiModelProperty(value = "브랜드 이름")
      @Column(name = "brand_name", columnDefinition = "VARCHAR(100)")
      private String brandName;
      
      @ApiModelProperty(value = "상품 제목")
      @Column(name = "title", columnDefinition = "VARCHAR(500)")
      private String title;
      
      @ApiModelProperty(value = "상품 이미지")
      @Column(name = "image", columnDefinition = "VARCHAR(800)")
      private String image;
      
      @ApiModelProperty(value = "상품 가격")
      @Column(name = "price", columnDefinition = "INT")
      private Integer price;
      
      @ApiModelProperty(value = "상품 할인율")
      @Column(name = "discount_rate", columnDefinition = "NUMERIC(3,2)")
      private float discountRate;
      
      @ApiModelProperty(value = "배송비")
      @Column(name = "delivery_fee", columnDefinition = "INT")
      private Integer deliveryFee;
      
      @ApiModelProperty(value = "특가")
      @Column(name = "special_price", columnDefinition = "INT")
      private Integer specialFee;
      
      @ApiModelProperty(value = "별점 합")
      @Column(name = "rating_sum", columnDefinition = "INT")
      private Integer ratingSum;
      
      @ApiModelProperty(value = "별점 개수")
      @Column(name = "rating_cnt", columnDefinition = "INT")
      private Integer ratingCnt;
      
      @ApiModelProperty(value = "상품 디테일 사항")
      @Column(name = "detail", columnDefinition = "TEXT")
      private String detail;
}
