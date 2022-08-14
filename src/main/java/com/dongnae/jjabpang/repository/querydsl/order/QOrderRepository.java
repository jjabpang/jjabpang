package com.dongnae.jjabpang.repository.querydsl.order;
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

import com.dongnae.jjabpang.dto.order.OrderListByEmailAndPagingResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface QOrderRepository {
      
      @Query(name = "주문 목록을 조회합니다. (해당 유저의 번호로 조회 및 페이징)")
      Page<OrderListByEmailAndPagingResponseDto> findOrderByUserNoOrderByCdtDESC(String userNo, Pageable pageable);
}
