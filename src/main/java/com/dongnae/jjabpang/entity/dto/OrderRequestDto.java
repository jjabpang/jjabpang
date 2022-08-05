package com.dongnae.jjabpang.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto implements Serializable {
      private String memo;
      private Long userNo;
      private Map<String, Integer> itemNoAndCountMap; // 아이템 번호와 카운트수 반환
      
      
}
