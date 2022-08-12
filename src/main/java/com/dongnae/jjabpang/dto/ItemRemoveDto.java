package com.dongnae.jjabpang.dto;

import lombok.Getter;

import java.util.List;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : ItemRemoveDto
 * author         : ipeac
 * date           : 2022-08-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-11        ipeac       최초 생성
 */
@Getter
public class ItemRemoveDto {
      private Long userNo;
      private List<Long> itemNo;
      
}
