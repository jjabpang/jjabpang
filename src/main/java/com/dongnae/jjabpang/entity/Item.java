package com.dongnae.jjabpang.entity;

import com.dongnae.jjabpang.exception.OutOfStockException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@ToString
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
      @Column(name = "brand_name", columnDefinition = "NVARCHAR(100)")
      private String brandName;
      
      @ApiModelProperty(value = "상품 제목")
      @Column(name = "title", columnDefinition = "NVARCHAR(500)")
      private String title;
      
      @ApiModelProperty(value = "상품 이미지")
      @Column(name = "image", columnDefinition = "VARCHAR(800)")
      private String image;
      
      @ApiModelProperty(value = "상품 가격")
      @Column(name = "price", columnDefinition = "INT")
      private Integer price;
      
      @ApiModelProperty(value = "상품 할인율")
      @Column(name = "discount_rate", columnDefinition = "NUMERIC(5,2) DEFAULT 0.00")
      private float discountRate;
      
      @ApiModelProperty(value = "배송비")
      @Column(name = "delivery_fee", columnDefinition = "INT")
      private Integer deliveryFee;
      
      @ApiModelProperty(value = "특가")
      @Column(name = "special_price", columnDefinition = "INT")
      private Integer specialFee;
      
      @ApiModelProperty(value = "별점 합")
      @Column(name = "rating_sum", columnDefinition = "NUMERIC(4,2) DEFAULT 0.00")
      private float ratingSum;
      
      @ApiModelProperty(value = "별점 개수")
      @Column(name = "rating_cnt", columnDefinition = "INT DEFAULT 0")
      private Integer ratingCnt;
      
      @ApiModelProperty(value = "상품 디테일 사항")
      @Column(name = "detail", columnDefinition = "TEXT")
      private String detail;
      
      @ApiModelProperty(value = "상품 재고")
      @Column(name = "quantity", columnDefinition = "INT")
      private Integer quantity;
      
      @OneToMany(fetch = LAZY, mappedBy = "item")
      @ApiModelProperty(name = "장바구니_상품")
      @ToString.Exclude
      List<CartItem> cartItemList;
      
      @ManyToOne(fetch = LAZY)
      @JoinColumn(name = "category")
      @ApiModelProperty(name = "카테고리")
      @ToString.Exclude
      private Category category;
      
      @OneToMany(mappedBy = "item", fetch = LAZY)
      @ToString.Exclude
      private List<Review> reviews = new ArrayList<>();
      
      @OneToMany(fetch = LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
      @JoinColumn(name = "item_no")
      private List<JjimItem> jjimItems = new ArrayList<>();
      
      public void removeStock(int quantity) throws OutOfStockException {
            int restQuantity = this.quantity - quantity;
            if (restQuantity < 0) {
                  throw new OutOfStockException("상품의 재고가 부족합니다. 현재 재고 수량 : " + this.quantity + "개");
            }
            this.quantity -= quantity;
      }
      
      public void addStock(Integer quantity) {
            this.quantity += quantity;
      }
}
