package com.dongnae.jjabpang.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
@ApiModel(value = "리뷰 요청 DTO")
@Data
public class ReviewDto implements Serializable {
      private String detail;
      private String summary;
      private Long itemNo;
      private Long userNo;
      private Long reviewNo;
      private List<ReviewImageDto> reviewImages;
      
      @Data
      public static class ReviewImageDto implements Serializable {
            private final String imageUrl;
      }
}
