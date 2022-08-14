package com.dongnae.jjabpang.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
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
      private String phoneNum;
      private String address1;
      private String address2;
      private String receiver;
      private List<Map<String, Integer>> data; // 아이템 번호와 카운트수 | 가격반환
      
}
