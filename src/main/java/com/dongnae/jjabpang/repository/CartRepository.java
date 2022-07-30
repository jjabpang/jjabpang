package com.dongnae.jjabpang.repository;

import com.dongnae.jjabpang.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartRepository extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart> {
      
}