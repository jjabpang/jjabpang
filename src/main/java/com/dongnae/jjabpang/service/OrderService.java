package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.Order;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.entity.dto.OrderRequestDto;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import com.dongnae.jjabpang.repository.order.OrderRepository;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
      private final UserRepository userRepository;
      private final ItemRepository itemRepository;
      
      /**
       * 주문 기능
       */
      @Transactional
      public Integer order(OrderRequestDto orderRequestDto) {
            // 유저번호로 유저찾기
            User user = userRepository.findByUserNo(orderRequestDto.getUser()
                                                                   .getUserNo());
            List<Item> itemList = orderRequestDto.getItem();
            for (Item item : itemList) {
                  Order order = new Order();
                  order.setUser(user);
                  order.setItem(item);
                  order.set
            }
            
            return 1;
      }
}
