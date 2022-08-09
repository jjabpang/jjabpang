package com.dongnae.jjabpang.repository.querydsl.review;

import com.dongnae.jjabpang.dto.ReviewListDto;
import com.dongnae.jjabpang.dto.ReviewSearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.dongnae.jjabpang.entity.QItem.item;
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
       * 동적 정렬 및 일반 페이징 평점 네임값 동적 조회
       */
      @Override
      public Page<ReviewListDto> findReviewByItemNoAndReviewNameOrderByDynamic(ReviewSearchCondition reviewSearchCondition, Pageable pageable) {
            
            
            return null;
      }
      
      private BooleanExpression categoryNoEq(String categoryNo) {
            if (isEmpty(categoryNo)) {
                  return null;
            }
            return item.category.categoryNo.eq(Long.valueOf(categoryNo));
      }
      
      private BooleanExpression nameContains(String name) {
            
            if (isEmpty(name)) {
                  return null;
            }
            return item.title.contains(name);
      }
}
