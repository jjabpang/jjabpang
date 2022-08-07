package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.CartItemDto;
import com.dongnae.jjabpang.entity.Cart;
import com.dongnae.jjabpang.entity.CartItem;
import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.cart.CartRepository;
import com.dongnae.jjabpang.repository.cartItem.CartItemRepository;
import com.dongnae.jjabpang.repository.item.ItemRepository;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/*
 *packageName    : com.dongnae.jjabpang.service
 * fileName       : CartService
 * author         : ipeac
 * date           : 2022-08-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-08        ipeac       최초 생성
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartService {
      
      private final CartRepository cartRepository;
      private final ItemRepository itemRepository;
      private final UserRepository userRepository;
      private final CartItemRepository cartItemRepository;
      
      
      /**
       * email 은 현재 로그인한 친구
       */
      public Long addCart(CartItemDto cartItemDto, String email) {
            Item item = itemRepository.findById(cartItemDto.getItemNo())
                                      .orElseThrow(() -> {
                                            throw new IllegalArgumentException("엔티티 조회 불가능");
                                      });
            /* 로그인한 유저 데이터*/
            Optional<User> loginedUser = userRepository.findByEmail(email);
            
            if (loginedUser.isPresent()) {
                  Cart cart = cartRepository.findByUser_UserNo(loginedUser.get()
                                                                          .getUserNo());
                  if (cart == null) {
                        cart = Cart.createCart(loginedUser.get());
                        cartRepository.save(cart);
                  }
                  
                  /* 현재 상품이 이미 장바구니에 들어가 있는지 검증*/
                  CartItem savedCartItem = cartItemRepository.findByItem_ItemNoAndCart_CartNo(item.getItemNo(), cart.getCartNo());
                  
                  /*이미 장바구니에 아이템이 들어가있다면 카운트 !*/
                  if (savedCartItem != null) {
                        savedCartItem.addCount(cartItemDto.getItemCount());
                        return savedCartItem.getCartItemNo();
                  } else {
                        CartItem cartItem = CartItem.createCartItem(cart, item, cartItemDto.getItemCount(), cartItemDto.getItemPrice());
                        cartItemRepository.save(cartItem);
                        return cartItem.getCartItemNo();
                  }
                  
            } else {
                  throw new IllegalStateException("로그인한 유저 데이터 없음");
            }
            
      }
}
