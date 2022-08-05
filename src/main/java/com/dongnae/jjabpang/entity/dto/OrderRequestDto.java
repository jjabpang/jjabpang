package com.dongnae.jjabpang.entity.dto;

import com.dongnae.jjabpang.entity.Item;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

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
      @CreatedDate
      private final LocalDateTime cdt;
      @LastModifiedDate
      private final LocalDateTime udt;
      private final String memo;
      private final UserForOrderDto user;
      private final Map<Item, Integer> itemAndCountMap;
      
      @Builder
      public OrderRequestDto(LocalDateTime cdt, LocalDateTime udt, String memo, UserForOrderDto user, Map<Item, Integer> itemAndCountMap) {
            this.cdt = cdt;
            this.udt = udt;
            this.memo = memo;
            this.user = user;
            this.itemAndCountMap = itemAndCountMap;
      }
}
