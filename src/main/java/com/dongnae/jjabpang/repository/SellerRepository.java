package com.dongnae.jjabpang.repository;

import com.dongnae.jjabpang.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SellerRepository extends JpaRepository<Seller, Integer>, JpaSpecificationExecutor<Seller> {
      
}