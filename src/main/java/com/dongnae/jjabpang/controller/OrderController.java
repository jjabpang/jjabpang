package com.dongnae.jjabpang.controller;
/*
 *packageName    : com.dongnae.jjabpang.controller
 * fileName       : OrderController
 * author         : ipeac
 * date           : 2022-08-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-04        ipeac       최초 생성
 */

import com.dongnae.jjabpang.repository.order.OrderRepository;
import com.dongnae.jjabpang.service.OrderService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order/")
@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = "주문")
public class OrderController {
      
      private final OrderService orderService;
      
      private final OrderRepository orderRepository;
}
