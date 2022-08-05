package com.dongnae.jjabpang.repository.querydsl.order;

import com.dongnae.jjabpang.entity.OrderItem;
import com.dongnae.jjabpang.entity.OrderListByEmailAndPagingResponseDto;
import com.dongnae.jjabpang.entity.QOrderListByEmailAndPagingResponseDto;
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
import static com.dongnae.jjabpang.entity.QOrder.order;
import static com.dongnae.jjabpang.entity.QOrderItem.orderItem;
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
public class QOrderRepositoryImpl implements QOrderRepository {
      
      private final JPAQueryFactory queryFactory;
      
      /**
       * 페이징 적용 유저번호 및
       */
      @Override
      public Page<OrderListByEmailAndPagingResponseDto> findOrderByUserNoOrderByCdtDESC(String userNo, Pageable pageable) {
            List<OrderListByEmailAndPagingResponseDto> result = queryFactory.select(new QOrderListByEmailAndPagingResponseDto(
                                                                                  order.cdt, order.udt, order.orderNo, order.status, order.memo, item.title, item.image, orderItem.quantity, orderItem.price
                                                                            ))
                                                                            .from(orderItem)
                                                                            .leftJoin(orderItem.order, order)
                                                                            .leftJoin(orderItem.item, item)
                                                                            .where(
                                                                                  userNoEq(userNo)
                                                                            )
                                                                            .offset(pageable.getOffset())
                                                                            .limit(pageable.getPageSize())
                                                                            .fetch();
            JPAQuery<OrderItem> countQuery = queryFactory.selectFrom(orderItem)
                                                         .leftJoin(orderItem.order, order)
                                                         .leftJoin(orderItem.item, item)
                                                         .where(
                                                               userNoEq(userNo)
                                                         );
            
            return PageableExecutionUtils.getPage(result, pageable, countQuery::fetchCount);
      }
      
      private BooleanExpression userNoEq(String userNo) {
            if (isEmpty(userNo)) {
                  return null;
            }
            
            return order.user.userNo.eq(Long.valueOf(userNo));
      }
      
}
