package com.dongnae.jjabpang.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : ReviewDto
 * author         : ipeac
 * date           : 2022-08-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-09        ipeac       최초 생성
 */
@Getter
@Setter
@AllArgsConstructor
@ApiModel(value = "리뷰 요청 DTO")
public class ReviewDto {
      private String detail;
      private String image;
      private Long itemNo;
}
