package com.dongnae.jjabpang.dto;

import lombok.Data;

/**
 * packageName    : com.dongnae.jjabpang.dto
 * fileName       : ReviewSearchCondition
 * author         : jihye94
 * date           : 2022-08-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-09        jihye94       최초 생성
 */
@Data
public class ReviewSearchCondition {
      private String itemNo;
      private String reviewName;
      private String orderBy;
      private String sort;
}
