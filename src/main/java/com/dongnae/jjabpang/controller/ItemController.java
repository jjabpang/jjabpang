package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.ItemCategoryOrNameResponseDto;
import com.dongnae.jjabpang.dto.ItemDto;
import com.dongnae.jjabpang.dto.ItemSearchCondition;
import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import com.dongnae.jjabpang.repository.querydsl.item.QItemRepository;
import com.dongnae.jjabpang.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
      
      @PostMapping("/items")
      @ApiOperation(value = "카테고리 및 제품명별 상품 조회 + 페이징 + 동적 정렬(최신, 높은 가격, 낮은 가격)")
      public Result findItemsByCategory(@RequestBody ItemSearchCondition itemSearchCondition, Pageable pageable) {
            
            
            Page<ItemCategoryOrNameResponseDto> result = itemService.findByCategoryAndNameOrderByCdtDESC(itemSearchCondition, pageable);
            
            return new Result(result);
      }
      
      /**
       * 상품번호로 상품 디테일 조회
       */
      @ApiOperation(value = "상품 상세정보 조회")
      @ApiImplicitParam(name = "itemNo", dataTypeClass = Long.class, value = "상품 번호", required = true, paramType = "query")
      @GetMapping("/items/{itemNo}")
      public Result findItemByItemNo(@ApiParam("아이템 번호") @PathVariable Long itemNo) {
            ModelMapper modelMapper = new ModelMapper();
            
            Optional<Item> result = itemRepository.findById(itemNo);
            List<Item> resultList = result.stream()
                                          .collect(Collectors.toList());
            List<ItemDto> detailDtoList = new ArrayList<>();
            
            if (result.isPresent()) {
                  for (Item item : resultList) {
                        ItemDto map = modelMapper.map(item, ItemDto.class);
                        detailDtoList.add(map);
                  }
                  
                  return new Result(detailDtoList);
            } else {
                  throw new IllegalStateException("조회된 상품 데이터가 없습니다");
            }
            
      }
}
