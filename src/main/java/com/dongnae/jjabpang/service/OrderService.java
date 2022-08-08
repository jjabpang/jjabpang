package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.OrderListByEmailAndPagingResponseDto;
import com.dongnae.jjabpang.dto.OrderRequestDto;
import com.dongnae.jjabpang.entity.*;
import com.dongnae.jjabpang.exception.OutOfStockException;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import com.dongnae.jjabpang.repository.order.OrderRepository;
import com.dongnae.jjabpang.repository.querydsl.order.QOrderRepository;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 *packageName    : com.dongnae.jjabpang.service
 * fileName       : OrderService
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
public class OrderService {
      
      private final OrderRepository orderRepository;
      private final QOrderRepository qOrderRepository;
      private final UserRepository userRepository;
      private final ItemRepository itemRepository;
      
      /**
       * 주문 기능
       */
      @Transactional
      public Integer order(OrderRequestDto orderRequestDto) throws OutOfStockException {
            // 유저번호로 유저찾기
            User user = userRepository.findByUserNo(orderRequestDto.getUserNo());
            
            // 구매하려고 하는 아아템의 리스트
            List<Map<String, Integer>> itemAndCountMap = orderRequestDto.getData();
            log.debug("itemAndCountMap = " + itemAndCountMap);
            
            Delivery delivery = new Delivery();
            delivery.setReceiver(orderRequestDto.getReceiver());
            delivery.setAddress1(orderRequestDto.getAddress1());
            delivery.setAddress2(orderRequestDto.getAddress2());
            
            // 다건 상품  | 주문 상품 생성
            for (Map<String, Integer> item : itemAndCountMap) {
                  
                  List<Item> result = itemRepository.findById(Long.valueOf(item.get("itemNo")))
                                                    .stream()
                                                    .collect(Collectors.toList());
                  
                  OrderItem orderItem = OrderItem.createOrderItem(result.get(0), item.get("itemPrice"), item.get("itemQuantity"));
                  
                  Order order = Order.createOrder(user, delivery, orderItem);
                  
                  orderRepository.save(order);
            }
            
            //전체 상품 개수
            return itemAndCountMap.size();
      }
      
      /**
       * 유저별 주문목록 조회 - 페이징
       */
      public Page<OrderListByEmailAndPagingResponseDto> findOrderByUserNoOrderByCdtDESC(String userNo, Pageable pageable) {
            log.debug("userNo = " + userNo);
            
            return qOrderRepository.findOrderByUserNoOrderByCdtDESC(userNo, pageable);
            
      }
      
      /**
       * 주문 취소 주문자와 현재 로그인된 사용자가 동일한지 검증
       */
      public boolean validateOrder(Long orderNo, Long userNo) {
            User curUser = userRepository.findById(userNo)
                                         .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));
            Order order = orderRepository.findById(orderNo)
                                         .orElseThrow(EntityNotFoundException::new);
            
            User orderUser = order.getUser();
            return Objects.equals(curUser.getUserNo(), orderUser.getUserNo());
      }
      
      @Transactional
      public void cancelOrder(Long orderNo) {
            Order order = orderRepository.findById(orderNo)
                                         .orElseThrow(EntityNotFoundException::new);
            order.cancelOrder();
            
      }
      
}
