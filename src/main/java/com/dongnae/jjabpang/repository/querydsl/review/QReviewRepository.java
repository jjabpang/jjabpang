package com.dongnae.jjabpang.repository.querydsl.review;
/*
 *packageName    : com.dongnae.jjabpang.repository.querydsl.order
 * fileName       : PostOrderRepository
 * author         : ipeac
 * date           : 2022-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-04        ipeac       최초 생성
 */

import com.dongnae.jjabpang.dto.ReviewListDto;
import com.dongnae.jjabpang.dto.condition.ReviewSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QReviewRepository {
      
      @Query(name = "리뷰 목록을 조회합니다 (페이징 및 동적 정렬 및 조건")
      Page<ReviewListDto> findReviewsDyPagingAndCondition(ReviewSearchCondition searchCondition, Pageable pageable);
      
      @Query(name = "리뷰 번호로 이미지 url 리스트 조회")
      List<String> findImageUrlByReviewNo(String reviewNo);
}
