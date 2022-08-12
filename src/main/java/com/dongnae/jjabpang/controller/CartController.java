package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.controller.UserController.Result;
import com.dongnae.jjabpang.dto.CartDetailDto;
import com.dongnae.jjabpang.dto.CartItemDto;
import com.dongnae.jjabpang.dto.ItemRemoveDto;
import com.dongnae.jjabpang.response.Message;
import com.dongnae.jjabpang.response.StatusEnum;
import com.dongnae.jjabpang.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *packageName    : com.dongnae.jjabpang.controller
 * fileName       : CartController
 * author         : ipeac
 * date           : 2022-08-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-08        ipeac       최초 생성
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "장바구니")
@RequestMapping("/api/cart")
public class CartController {
      
      private final CartService cartService;
      
      @ApiOperation(value = "장바구니 추가")
      @PostMapping("/cart")
      public ResponseEntity cartOrder(@RequestBody @Valid CartItemDto cartItemDto, BindingResult bindingResult) {
            Map<String, Long> data = new HashMap<>();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
            Message message = new Message();
            
            if (bindingResult.hasErrors()) {
                  StringBuilder sb = new StringBuilder();
                  List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                  for (FieldError fieldError : fieldErrors) {
                        sb.append(fieldError.getDefaultMessage());
                  }
                  
                  return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
            }
            Long cartItemNo;
            try {
                  cartItemNo = cartService.addCart(cartItemDto, cartItemDto.getUserEmail());
            } catch (Exception e) {
                  return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
                  
            }
            message.setMessage("장바구니 저장 성공");
            data.put("cartItemNo", cartItemNo);
            message.setData(data);
            message.setStatus(StatusEnum.OK);
            return new ResponseEntity<>(message, headers, HttpStatus.OK);
      }
      
      @ApiOperation(value = "장바구니 아이템 삭제")
      @DeleteMapping("/cart")
      public ResponseEntity removeCartItem(@RequestBody ItemRemoveDto dto) throws Exception {
            
            return cartService.removeCart(dto);
      }
      
      @ApiOperation(value = "회원별 장바구니 조회")
      @GetMapping("/cart/{userNo}")
      public Result findCart(@PathVariable Long userNo) throws Exception {
            List<CartResult> cartDetailDtoList = new ArrayList<>();
            List<CartDetailDto> cartList = cartService.getCartList(userNo);
            int index = 0;
            for (CartDetailDto cartDetailDto : cartList) {
                  CartResult<CartDetailDto> cartDetailDtoCartResult = new CartResult<>(cartDetailDto);
                  cartDetailDtoList.add(cartDetailDtoCartResult);
            }
            
            return new Result(cartDetailDtoList);
      }
      
      @Data
      @AllArgsConstructor
      class CartResult<T> {
            private T cart;
      }
}
