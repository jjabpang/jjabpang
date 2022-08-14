package com.dongnae.jjabpang.dto.order;

import com.dongnae.jjabpang.entity.Status;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

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
      private String cdt;
      private String udt;
      private Long orderNo;
      private Status status;
      private String memo;
      private String itemTitle;
      private String itemImage;
      private int orderQuantity;
      private int orderPrice;
      
      @QueryProjection
      @Builder
      public OrderListByEmailAndPagingResponseDto(String cdt, String udt, Long orderNo, Status status, String memo, String itemTitle, String itemImage, int orderQuantity, int orderPrice) {
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
