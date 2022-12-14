package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.cart.CartItemDto;
import com.dongnae.jjabpang.entity.Cart;
import com.dongnae.jjabpang.entity.CartItem;
import com.dongnae.jjabpang.entity.Item;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.CartItemRepository;
import com.dongnae.jjabpang.repository.CartRepository;
import com.dongnae.jjabpang.repository.ItemRepository;
import com.dongnae.jjabpang.repository.UserRepository;
import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@WebAppConfiguration
@Transactional
class CartServiceTest {
      
      private final static Logger logger = LoggerFactory.getLogger(CartServiceTest.class);
      
      @Autowired
      private CartRepository cartRepository;
      
      @Autowired
      private ItemRepository itemRepository;
      
      @Autowired
      private UserRepository userRepository;
      
      @Autowired
      private CartItemRepository cartItemRepository;
      
      @BeforeClass
      @Sql({"classpath:db/dataTest.sql"})
      public static void setUpBeforeClass() throws Exception {
            logger.debug("Test Data Create And Insert!");
            
      }
      
      
      @Test
      @DisplayName(value = "장바구니 추가 테스트")
      void addCart() {
            User user = new User();
            user.setUserNo(1L);
            user.setEmail("qkrtkdwns3410@naver.com");
            user.setPhoneNm("010-1111-1111");
            
            Item creatItem = new Item(1L, "coco", "dd", "dd", 10000, 0.0f, 100, 0, 0, 1, "디테일", 3, null, null, null, null);
            
            userRepository.save(user);
            
            itemRepository.save(creatItem);
            
            /* 카트 아이템 dto 설정*/
            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setItemCount(3);
            cartItemDto.setItemPrice(42900 * 3);
            cartItemDto.setItemNo(1L);
            cartItemDto.setUserEmail("qkrtkdwns3410@naver.com");
            
            Item item = itemRepository.findById(cartItemDto.getItemNo())
                                      .orElseThrow(() -> {
                                            throw new IllegalArgumentException("엔티티 조회 불가능");
                                      });
            
            /* 로그인한 유저 데이터*/
            Optional<User> loginedUser = userRepository.findAllByEmail(cartItemDto.getUserEmail());
            
            if (loginedUser.isPresent()) {
                  Cart cart = cartRepository.findByUser_UserNo(loginedUser.get()
                                                                          .getUserNo());
                  if (cart == null) {
                        cart = Cart.createCart(loginedUser.get());
                        cartRepository.save(cart);
                  }
                  
                  /* 현재 상품이 이미 장바구니에 들어가 있는지 검증*/
                  CartItem savedCartItem = cartItemRepository.findByItem_ItemNoAndCart_CartNo(item.getItemNo(), cart.getCartNo());
                  CartItem cartItem;
                  
                  /*이미 장바구니에 아이템이 들어가있다면 카운트 !*/
                  if (savedCartItem != null) {
                        savedCartItem.addCount(cartItemDto.getItemCount());
                        // 카트아이템에 들어간 아이템 번호 검증
                        assertThat(savedCartItem.getItem()
                                                .getItemNo()).isEqualTo(1L);
                        
                        //카트아이템에 들어간 카트번호를 통해 > 유저검증
                        assertThat(savedCartItem.getCart()
                                                .getUser()
                                                .getUserNo()).isEqualTo(1L);
                  } else {
                        cartItem = CartItem.createCartItem(cart, item, cartItemDto.getItemCount(), cartItemDto.getItemPrice());
                        cartItemRepository.save(cartItem);
                        // 카트아이템에 들어간 아이템 번호 검증
                        assertThat(cartItem.getItem()
                                           .getItemNo()).isEqualTo(1L);
                        //카트아이템에 들어간 카트번호를 통해 > 유저검증
                        assertThat(cartItem.getCart()
                                           .getUser()
                                           .getUserNo()).isEqualTo(1L);
                  }
                  
                  
            } else {
                  throw new IllegalStateException("로그인한 유저 데이터 없음");
            }
            
      }
      
      @Test
      void getCartList() {
      
      }
      
      @Test
      void removeCart() {
      
      }
}