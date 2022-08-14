package com.dongnae.jjabpang.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * packageName    : com.dongnae.jjabpang.dto
 * fileName       : JjimRemoveDto
 * author         : jihye94
 * date           : 2022-08-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-14        jihye94       최초 생성
 */
@Data
@ApiModel(description = "찜삭제 요청 dto")
public class JjimRemoveDto {
      @ApiModelProperty(name = "찜상품번호")
      private Long jjimItemNo;
      @ApiModelProperty(name = "유저번호")
      private Long userNo;
}
