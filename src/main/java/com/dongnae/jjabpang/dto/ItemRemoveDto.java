package com.dongnae.jjabpang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

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
@ApiModel(description = "삭제할 아이템의 요청 데이터")
public class ItemRemoveDto {
      @ApiModelProperty(name = "유저번호")
      private Long userNo;
      @ApiModelProperty(name = "삭제될 아이템들의 번호")
      private Long itemNo;
      @ApiModelProperty(name = "장바구니의 번호")
      private Long cartNo;
      
      
}
