package com.dongnae.jjabpang.repository;

import com.dongnae.jjabpang.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Long> {
      /**
       * 유저번호로 장바구니 찾기 유저당.. 장바구니는 하나씩임
       */
      @Query("select c from Cart c where c.user.userNo = ?1")
      Cart findByUser_UserNo(Long userNo);
      
      
}