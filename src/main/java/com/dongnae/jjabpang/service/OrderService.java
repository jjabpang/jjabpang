package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.entity.*;
import com.dongnae.jjabpang.entity.dto.OrderRequestDto;
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

import java.util.List;
import java.util.Map;
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
      public Integer order(OrderRequestDto orderRequestDto) {
            // 유저번호로 유저찾기
            User user = userRepository.findByUserNo(orderRequestDto.getUserNo());
            
            // 구매하려고 하는 아아템의 리스트
            Map<String, Integer> itemAndCountMap = orderRequestDto.getItemNoAndCountMap();
            log.debug("itemAndCountMap = " + itemAndCountMap);
            
            Delivery delivery = new Delivery();
            delivery.setAddress1(user.getAddress1());
            delivery.setAddress2(user.getAddress2());
            delivery.setDeliveryStatus(DeliveryStatus.READY);
            
            // 다건 상품  | 주문 상품 생성
            for (Map.Entry<String, Integer> item : itemAndCountMap.entrySet()) {
                  
                  List<Item> result = itemRepository.findById(Long.valueOf(item.getKey()))
                                                    .stream()
                                                    .collect(Collectors.toList());
                  
                  OrderItem orderItem = OrderItem.createOrderItem(result.get(0), result.get(0)
                                                                                       .getPrice(), result.get(0)
                                                                                                          .getQuantity());
                  
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
      
}
