package com.dongnae.jjabpang.dto.jjim;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * packageName    : com.dongnae.jjabpang.dto
 * fileName       : JjimListDto
 * author         : jihye94
 * date           : 2022-08-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-13        jihye94       최초 생성
 */
@Data
@ApiModel(description = "찜리스트 DTO")
public class JjimListDto {
      @ApiModelProperty(name = "유저 번호")
      private Long userNo;
}
