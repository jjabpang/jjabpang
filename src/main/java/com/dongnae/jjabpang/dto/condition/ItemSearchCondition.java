package com.dongnae.jjabpang.dto.condition;

import lombok.Data;

/*
 *packageName    : com.dongnae.jjabpang.entity.dto
 * fileName       : ItemSearchCondition
 * author         : ipeac
 * date           : 2022-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-04        ipeac       최초 생성
 */
@Data
public class ItemSearchCondition {
      private String categoryNo;
      private String name;
      private String orderBy;
      private String sort;
}
