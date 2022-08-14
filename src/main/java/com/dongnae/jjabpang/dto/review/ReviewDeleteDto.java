package com.dongnae.jjabpang.dto.review;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : ReviewDeleteDto
 * author         : ipeac
 * date           : 2022-08-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-12        ipeac       최초 생성
 */
@Getter
@ApiModel(description = "리뷰 삭제 dto")
public class ReviewDeleteDto {
      private Long reviewNo;
      private Long userNo;
}
