package com.dongnae.jjabpang.entity.dto;

import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.dongnae.jjabpang.entity.dto
 * fileName       : OrderRequestDto
 * author         : jihye94
 * date           : 2022-08-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-05        jihye94       최초 생성
 */
@Data
public class OrderRequestDto implements Serializable {
      private final LocalDateTime cdt;
      private final LocalDateTime udt;
      private final Long orderNo;
      private final Integer quantity;
      private final Status status;
      private final String memo;
      private final UserForOrderDto user;
      private final List<Item> item;
      
      @Builder
      public OrderRequestDto(LocalDateTime cdt, LocalDateTime udt, Long orderNo, Integer quantity, Status status, String memo, UserForOrderDto user) {
            this.cdt = cdt;
            this.udt = udt;
            this.orderNo = orderNo;
            this.quantity = quantity;
            this.status = status;
            this.memo = memo;
            this.user = user;
            this.item = new ArrayList<>();
      }
}
