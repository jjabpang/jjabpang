package com.dongnae.jjabpang.repository.querydsl.item;

import com.dongnae.jjabpang.dto.ItemCategoryOrNameResponseDto;
import com.dongnae.jjabpang.dto.ItemSearchCondition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class QItemRepositoryTest {
      
      @Autowired
      private QItemRepository qItemRepository;
      
      
      @Test
      void findByCategoryAndNameOrderByCdtDESC() throws Exception {
            ItemSearchCondition itemSearchCondition = new ItemSearchCondition();
            
            itemSearchCondition.setName("홈플래닛");
            itemSearchCondition.setCategoryNo("3");
            
            PageRequest pageRequest = PageRequest.of(0, 10);
            Page<ItemCategoryOrNameResponseDto> result = qItemRepository.findByCategoryAndNameOrderByCdtDESC(itemSearchCondition, pageRequest);
            
            for (ItemCategoryOrNameResponseDto itemCategoryOrNameResponseDto : result) {
                  System.out.println("itemCategoryOrNameRequestDto = " + itemCategoryOrNameResponseDto);
            }
      }
}