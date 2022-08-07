package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.entity.dto.ItemCategoryOrNameResponseDto;
import com.dongnae.jjabpang.entity.dto.ItemSearchCondition;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import com.dongnae.jjabpang.repository.querydsl.item.QItemRepository;
import com.dongnae.jjabpang.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dongnae.jjabpang.controller.UserController.Result;

/*
 *packageName    : com.dongnae.jjabpang.controller
 * fileName       : ItemController
 * author         : ipeac
 * date           : 2022-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-04        ipeac       최초 생성
 */
@RequestMapping("/api/item/")
@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = "상품")
public class ItemController {
      
      private final ItemService itemService;
      private final ItemRepository itemRepository;
      private final QItemRepository qItemRepository;
      
      @GetMapping("/items")
      @ApiOperation(value = "카테고리 및 제품명별 상품 조회")
      public Result findItemsByCategory(@RequestBody ItemSearchCondition itemSearchCondition, Pageable pageable) {
            
            Page<ItemCategoryOrNameResponseDto> result = itemService.findByCategoryAndNameOrderByCdtDESC(itemSearchCondition.getCategoryNo(), itemSearchCondition.getName(), pageable);
            
            return new Result(result);
      }
      
}
