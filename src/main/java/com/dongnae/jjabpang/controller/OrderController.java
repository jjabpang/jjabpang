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

import com.dongnae.jjabpang.controller.UserController.Result;
import com.dongnae.jjabpang.dto.order.OrderListByEmailAndPagingResponseDto;
import com.dongnae.jjabpang.dto.order.OrderRequestDto;
import com.dongnae.jjabpang.exception.OutOfStockException;
import com.dongnae.jjabpang.response.Message;
import com.dongnae.jjabpang.response.StatusEnum;
import com.dongnae.jjabpang.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RequestMapping("/api/order/")
@RestController
@Slf4j
@RequiredArgsConstructor
@Api(tags = "주문")
public class OrderController {
      
      private final OrderService orderService;
      
      @ApiOperation(value = "상품 주문")
      @PostMapping("/orderItem")
      public ResponseEntity<Message> order(@RequestBody OrderRequestDto orderRequestDto) throws Exception, OutOfStockException {
            log.debug("OrderController.order ");
            log.debug("orderRequestDto = " + orderRequestDto);
            
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
            Integer resultRow = orderService.order(orderRequestDto);
            
            message.setStatus(StatusEnum.OK);
            message.setMessage("주문 성공 (Data : 반영 행수)");
            message.setData(resultRow);
            return new ResponseEntity<>(message, headers, HttpStatus.OK);
      }
      
      @ApiOperation(value = "상품 주문 취소")
      @PostMapping("/orderItem/{orderNo}/{userNo}")
      public ResponseEntity order(@PathVariable Long orderNo, @PathVariable Long userNo) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            Message message = new Message();
            
            if (!orderService.validateOrder(orderNo, userNo)) {
                  return new ResponseEntity<String>("주문 취소 권한이 없습니다.", HttpStatus.FORBIDDEN);
            }
            orderService.cancelOrder(orderNo);
            
            
            message.setStatus(StatusEnum.OK);
            message.setMessage("주문 취소 완료");
            
            return new ResponseEntity<Message>(message, headers, HttpStatus.OK);
      }
      
      @ApiOperation(value = "상품 주문 목록 전체 조회")
      @ApiImplicitParam(name = "userNo", dataTypeClass = Long.class, value = "회원 번호", paramType = "query", required = true)
      @GetMapping("/orderItem/{userNo}")
      public Result findAllOrders(@PathVariable String userNo, Pageable pageable) {
            
            Page<OrderListByEmailAndPagingResponseDto> result = orderService.findOrderByUserNoOrderByCdtDESC(userNo, pageable);
            
            return new Result<>(result);
      }
}
