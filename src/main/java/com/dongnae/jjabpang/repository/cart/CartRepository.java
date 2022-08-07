package com.dongnae.jjabpang.repository.cart;

import com.dongnae.jjabpang.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Long> {
      /**
       * 장바구니에 들어갈 상품 조회
       */
      @Query("select c from Cart c where c.user.userNo = ?1")
      Cart findByUser_UserNo(Long userNo);
      
      
}