package com.dongnae.jjabpang.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * packageName    : com.dongnae.jjabpang.dto
 * fileName       : JjimAddDto
 * author         : jihye94
 * date           : 2022-08-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-13        jihye94       최초 생성
 */
@Data
@ApiModel(description = "찜추가 DTO")
public class JjimAddDto {
      private Long itemNo;
      private Long userNo;
      
}
