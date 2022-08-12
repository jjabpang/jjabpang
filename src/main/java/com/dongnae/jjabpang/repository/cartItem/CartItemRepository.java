package com.dongnae.jjabpang.repository.cartItem;

import com.dongnae.jjabpang.dto.CartDetailDto;
import com.dongnae.jjabpang.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
      /**
       * 장바구니에 들어갈 상품을 저장하거나 조회
       */
      CartItem findByItem_ItemNoAndCart_CartNo(Long itemNo, Long cartNo);
      
      /**
       * 장바구니 장바구니 번호 기준 상품 조회
       */
      @Query(value =
                   "select new com.dongnae.jjabpang.dto.CartDetailDto(ci.cartItemNo,i.title,i.image,i.price,ci.itemCount,i.deliveryFee) " +
                   "from CartItem ci " +
                   "left join ci.item  i " +
                   "left join ci.cart  c " +
                   "where ci.cart.cartNo = :cartNo " +
                   "and i.itemNo = ci.item.itemNo " +
                   "order by ci.udt DESC ")
      List<CartDetailDto> findCartDetailDtoList(@Param(value = "cartNo") Long cartNo);
      
      
      List<CartItem> findCartItemByCart_CartNo(@Param(value = "cartNo") Long cartNo);
      
      
}