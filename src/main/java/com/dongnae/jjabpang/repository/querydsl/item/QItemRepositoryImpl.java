package com.dongnae.jjabpang.repository.querydsl.item;

import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.dto.ItemCategoryOrNameResponseDto;
import com.dongnae.jjabpang.entity.dto.QItemCategoryOrNameRequestDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dongnae.jjabpang.entity.QCategory.category;
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
public class QItemRepositoryImpl implements QItemRepository {
      
      private final JPAQueryFactory queryFactory;
      
      /**
       * 페이징 적용 카테고리
       */
      @Override
      public Page<ItemCategoryOrNameResponseDto> findByCategoryAndNameOrderByCdtDESC(String categoryNo, String name, Pageable pageable) {
            List<ItemCategoryOrNameResponseDto> content = queryFactory.select(new QItemCategoryOrNameRequestDto(item.cdt, item.udt, item.itemNo, item.title, item.image, item.price, item.discountRate, item.deliveryFee, item.specialFee, item.ratingSum, item.ratingCnt))
                                                                      .from(item)
                                                                      .leftJoin(item.category, category)
                                                                      .where(
                                                                            categoryNoEq(categoryNo)
                                                                            , nameContains(name)
                                                                      )
                                                                      .offset(pageable.getOffset())
                                                                      .limit(pageable.getPageSize())
                                                                      .fetch();
            
            JPAQuery<Item> countQuery = queryFactory
                                              .selectFrom(item)
                                              .leftJoin(item.category, category)
                                              .where(
                                                    categoryNoEq(categoryNo)
                                                    , nameContains(name)
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
}
