package com.dongnae.jjabpang.repository.querydsl.item;
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

import com.dongnae.jjabpang.dto.ItemCategoryOrNameResponseDto;
import com.dongnae.jjabpang.dto.condition.ItemSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface QItemRepository {
      
      @Query(name = "해당 카테고리 번호를 가진 목록만 불러옵니다. 페이징 적용")
      Page<ItemCategoryOrNameResponseDto> findByCategoryAndNameOrderByCdtDESC(ItemSearchCondition searchCondition, Pageable pageable);
}
