package com.dongnae.jjabpang.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * packageName    : com.dongnae.jjabpang.dto
 * fileName       : ReviewListDto
 * author         : jihye94
 * date           : 2022-08-09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-09        jihye94       최초 생성
 */
@Data
public class ReviewListDto implements Serializable {
      private final String cdt;
      private final String udt;
      private final Long reviewNo;
      private final String detail;
      private final String summary;
      private final String delYn;
      private final Long itemItemNo;
      private final Long userUserNo;
      private final List<ReviewImageDto> reviewImages;
      
      @QueryProjection
      public ReviewListDto(String cdt, String udt, Long reviewNo, String detail, String summary, String delYn, Long itemItemNo, Long userUserNo, List<ReviewImageDto> reviewImages) {
            this.cdt = cdt;
            this.udt = udt;
            this.reviewNo = reviewNo;
            this.detail = detail;
            this.summary = summary;
            this.delYn = delYn;
            this.itemItemNo = itemItemNo;
            this.userUserNo = userUserNo;
            this.reviewImages = reviewImages;
      }
      
      @Data
      public static class ReviewImageDto implements Serializable {
            private final Long reviewImageNo;
            private final String imageUrl;
      }
}
