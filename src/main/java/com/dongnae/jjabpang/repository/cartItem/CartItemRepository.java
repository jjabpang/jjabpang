package com.dongnae.jjabpang.repository.cartItem;

import com.dongnae.jjabpang.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
      /**
       * 장바구니에 들어갈 상품을 저장하거나 조회
       */
      CartItem findByItem_ItemNoAndCart_CartNo(Long itemNo, Long cartNo);
      
      
}