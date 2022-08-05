package com.dongnae.jjabpang.entity;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : OrderListByUserNoAndPagingResponseDto
 * author         : jihye94
 * date           : 2022-08-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-05        jihye94       최초 생성
 */
@Data
public class OrderListByEmailAndPagingResponseDto implements Serializable {
      private final LocalDateTime cdt;
      private final LocalDateTime udt;
      private final Long orderNo;
      private final Status status;
      private final String memo;
      private final String itemTitle;
      private final String itemImage;
      private final int orderQuantity;
      private final int orderPrice;
      
      @QueryProjection
      @Builder
      public OrderListByEmailAndPagingResponseDto(LocalDateTime cdt, LocalDateTime udt, Long orderNo, Status status, String memo, String itemTitle, String itemImage, int orderQuantity, int orderPrice) {
            this.cdt = cdt;
            this.udt = udt;
            this.orderNo = orderNo;
            this.status = status;
            this.itemTitle = itemTitle;
            this.itemImage = itemImage;
            this.memo = memo;
            this.orderQuantity = orderQuantity;
            this.orderPrice = orderPrice;
      }
      
      
      @Data
      public static class OrderItemDto implements Serializable {
            private final Integer quantity;
            private final Integer price;
      }
}
