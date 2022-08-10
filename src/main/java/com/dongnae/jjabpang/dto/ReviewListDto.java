package com.dongnae.jjabpang.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : ReviewListDto
 * author         : ipeac
 * date           : 2022-08-10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-10        ipeac       최초 생성
 */
@Setter
@Getter
@ApiModel(description = "리뷰 목록 조회를 위한 dto")
public class ReviewListDto {
      private Long reviewNo;
      private String detail;
      private String summary;
      private Integer starCnt;
      private Long itemNo;
      private Long userNo;
      
      @QueryProjection
      public ReviewListDto(Long reviewNo, String detail, String summary, Integer starCnt, Long itemNo, Long userNo) {
            this.reviewNo = reviewNo;
            this.detail = detail;
            this.summary = summary;
            this.starCnt = starCnt;
            this.itemNo = itemNo;
            this.userNo = userNo;
      }
}
