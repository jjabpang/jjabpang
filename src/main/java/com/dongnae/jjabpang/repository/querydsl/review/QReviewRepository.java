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
import com.dongnae.jjabpang.dto.ReviewSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface QReviewRepository {
      
      @Query(name = "페이징 적용 , 삭제되지 않은 리뷰 목록을 불러옵니다. ")
      Page<ReviewListDto> findReviewByItemNoAndReviewNameOrderByDynamic(ReviewSearchCondition reviewSearchCondition, Pageable pageable);
}
