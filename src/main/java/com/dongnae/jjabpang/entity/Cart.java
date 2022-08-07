package com.dongnae.jjabpang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : Cart
 * author         : jihye94
 * date           : 2022-08-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-03        jihye94       최초 생성
 */
@NoArgsConstructor()
@Getter
@Setter
@Entity
@Table(name = "cart")
@ApiModel("장바구니")
public class Cart extends BaseTimeEntity {
      @Id
      @Column(name = "cart_no", nullable = false)
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @ApiModelProperty(name = "장바구니 번호", required = true)
      private Long cartNo;
      
      @ApiModelProperty(value = "회원")
      @OneToOne(fetch = LAZY)
      @JoinColumn(name = "user_no")
      private User user;
      
      @ApiModelProperty(value = "장바구니_상품")
      @OneToMany(fetch = LAZY, mappedBy = "cart")
      private List<CartItem> cartItemList = new ArrayList<>();
      
      public static Cart createCart(User user) {
            Cart cart = new Cart();
            cart.setUser(user);
            return cart;
      }
}
