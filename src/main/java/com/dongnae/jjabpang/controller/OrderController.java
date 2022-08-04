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

import com.dongnae.jjabpang.entity.dto.OrderRequestDto;
import com.dongnae.jjabpang.repository.order.OrderRepository;
import com.dongnae.jjabpang.response.Message;
import com.dongnae.jjabpang.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
      
      @ApiModelProperty(name = "상품 주문")
      @PostMapping("/orderItem")
      public ResponseEntity<Message> order(@RequestBody OrderRequestDto orderRequestDto) {
            Message message = new Message();
            
            return new ResponseEntity<>()
      }
}
