package com.dongnae.jjabpang.repository.querydsl.item;

import com.dongnae.jjabpang.dto.ItemCategoryOrNameResponseDto;
import com.dongnae.jjabpang.dto.QItemCategoryOrNameResponseDto;
import com.dongnae.jjabpang.dto.condition.ItemSearchCondition;
import com.dongnae.jjabpang.entity.Item;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dongnae.jjabpang.entity.QCategory.category;
import static com.dongnae.jjabpang.entity.QItem.item;
import static com.dongnae.jjabpang.entity.QReview.review;
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
public class QItemRepositoryImpl implements QItemRepository {
      
      private final JPAQueryFactory queryFactory;
      
      
      /**
       * 페이징 적용 카테고리
       */
      @Override
      public Page<ItemCategoryOrNameResponseDto> findByCategoryAndNameOrderByCdtDESC(ItemSearchCondition searchCondition, Pageable pageable) {
            List<ItemCategoryOrNameResponseDto> content = queryFactory.select(new QItemCategoryOrNameResponseDto(item.itemNo, item.title, item.image, item.price, item.discountRate, item.deliveryFee, item.specialFee, item.ratingSum, item.ratingCnt))
                                                                      .from(item)
                                                                      .leftJoin(item.category, category)
                                                                      .where(
                                                                            categoryNoEq(searchCondition.getCategoryNo())
                                                                            , nameContains(searchCondition.getName())
                                                                      )
                                                                      .orderBy(boardSort(pageable))
                                                                      .offset(pageable.getOffset())
                                                                      .limit(pageable.getPageSize())
                                                                      .fetch();
            
            JPAQuery<Item> countQuery = queryFactory
                                              .selectFrom(item)
                                              .leftJoin(item.category, category)
                                              .where(
                                                    categoryNoEq(searchCondition.getCategoryNo())
                                                    , nameContains(searchCondition.getName())
                                              );
            
            return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
            
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
      
      /**
       * OrderSpecifier 를 쿼리로 반환하여 정렬조건을 맞춰준다.
       * 리스트 정렬
       *
       * @param page
       * @return
       */
      public static OrderSpecifier<?> boardSort(Pageable page) {
            //서비스에서 보내준 Pageable 객체에 정렬조건 null 값 체크
            if (!page.getSort()
                     .isEmpty()) {
                  //정렬값이 들어 있으면 for 사용하여 값을 가져온다
                  for (Sort.Order order : page.getSort()) {
                        // 서비스에서 넣어준 DESC or ASC 를 가져온다.
                        Order direction = order.getDirection()
                                               .isAscending() ? Order.ASC : Order.DESC;
                        // 서비스에서 넣어준 정렬 조건을 스위치 케이스 문을 활용하여 셋팅하여 준다.
                        switch (order.getProperty()) {
                              case "item.cdt":
                                    return new OrderSpecifier(direction, item.cdt);
                              case "item.price":
                                    return new OrderSpecifier(direction, item.price);
                              case "review.cdt":
                                    return new OrderSpecifier(direction, review.cdt);
                        }
                        
                  }
            }
            return null;
      }
}
