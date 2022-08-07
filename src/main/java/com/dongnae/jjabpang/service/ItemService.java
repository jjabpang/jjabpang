package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.entity.dto.ItemCategoryOrNameResponseDto;
import com.dongnae.jjabpang.entity.dto.ItemSearchCondition;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import com.dongnae.jjabpang.repository.querydsl.item.QItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 *packageName    : com.dongnae.jjabpang.service
 * fileName       : ItemService
 * author         : ipeac
 * date           : 2022-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-04        ipeac       최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ItemService {
      private final ItemRepository itemRepository;
      
      private final QItemRepository qItemRepository;
      
      
      /*카테고리 별 상품 조회*/
      public Page<ItemCategoryOrNameResponseDto> findByCategoryAndNameOrderByCdtDESC(ItemSearchCondition searchCondition, Pageable pageable) {
            
            PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.fromString(searchCondition.getOrderBy()), searchCondition.getSort()));
            
            return qItemRepository.findByCategoryAndNameOrderByCdtDESC(searchCondition, pageRequest);
            
      }
}
