package com.dongnae.jjabpang.repository.querydsl.review;

import com.dongnae.jjabpang.dto.QReviewListDto;
import com.dongnae.jjabpang.dto.ReviewListDto;
import com.dongnae.jjabpang.dto.ReviewSearchCondition;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.dongnae.jjabpang.entity.QItem.item;
import static com.dongnae.jjabpang.entity.QReview.review;
import static com.dongnae.jjabpang.entity.QReviewImage.reviewImage;
import static com.dongnae.jjabpang.entity.QUser.user;

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
@Repository
@RequiredArgsConstructor
public class QReviewRepositoryImpl implements QReviewRepository {
      
      private final JPAQueryFactory queryFactory;
      
      /**
       * 동적 정렬 및 일반 페이징 평점 네임값 동적 조회 - 별점별 조회 기능 추가
       */
      @Override
      public Page<ReviewListDto> findReviewByItemNoAndReviewNameOrderByDynamic(ReviewSearchCondition reviewSearchCondition, Pageable pageable) {
            queryFactory.select(new QReviewListDto(review.cdt, review.udt, review.reviewNo, review.detail, review.summary, review.delYn, ))
                        .from(review)
                        .leftJoin(review.item, item)
                        .leftJoin(review.reviewNo, reviewImage)
                        .leftJoin(review.user, user)
            return null;
      }
      
      
}
