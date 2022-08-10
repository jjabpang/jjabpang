package com.dongnae.jjabpang.repository.querydsl.review;

import com.dongnae.jjabpang.dto.QReviewListDto;
import com.dongnae.jjabpang.dto.ReviewListDto;
import com.dongnae.jjabpang.dto.condition.ReviewSearchCondition;
import com.dongnae.jjabpang.entity.Review;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dongnae.jjabpang.entity.QItem.item;
import static com.dongnae.jjabpang.entity.QReview.review;
import static com.dongnae.jjabpang.entity.QReviewImage.reviewImage;
import static com.dongnae.jjabpang.entity.QUser.user;
import static com.dongnae.jjabpang.repository.querydsl.item.QItemRepositoryImpl.boardSort;
import static org.springframework.util.StringUtils.isEmpty;

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
       * 리뷰 목록만 조회  - 이미지 제외
       */
      @Override
      public Page<ReviewListDto> findReviewsDyPagingAndCondition(ReviewSearchCondition searchCondition, Pageable pageable) {
            
            List<ReviewListDto> content = queryFactory.select(new QReviewListDto(review.reviewNo, review.detail, review.detail, review.starCnt, item.itemNo, user.userNo))
                                                      .from(review)
                                                      .leftJoin(review.item, item)
                                                      .leftJoin(review.user, user)
                                                      .where(
                                                            detailEq(searchCondition.getReviewDetail()),
                                                            starCntEq(searchCondition.getReviewStarCnt())
                                                      )
                                                      .orderBy(boardSort(pageable))
                                                      .offset(pageable.getOffset())
                                                      .limit(pageable.getPageSize())
                                                      .fetch();
            
            JPAQuery<Review> countQuery = queryFactory.selectFrom(review)
                                                      .leftJoin(review.item, item)
                                                      .leftJoin(review.user, user)
                                                      .where(
                                                            detailEq(searchCondition.getReviewDetail()),
                                                            starCntEq(searchCondition.getReviewStarCnt())
                                                      );
            
            return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
      }
      
      /**
       * 리뷰번호로 이미지 조회
       */
      @Override
      public List<String> findReviewsDyPagingAndCondition(String reviewNo) {
            
            List<String> imageUrlList = queryFactory.from(reviewImage)
                                                    .select(reviewImage.imageUrl)
                                                    .where(
                                                          reviewImage.review.reviewNo.eq(Long.valueOf(reviewNo))
                                                    )
                                                    .fetch();
            
            
            return imageUrlList;
      }
      
      
      private BooleanExpression starCntEq(Integer reviewStarCnt) {
            if (isEmpty(reviewStarCnt)) {
                  return null;
            }
            return review.starCnt.eq(reviewStarCnt);
      }
      
      
      private BooleanExpression detailEq(String reviewDetail) {
            if (isEmpty(reviewDetail)) {
                  return null;
            }
            return review.detail.contains(reviewDetail);
      }
      
      
}
