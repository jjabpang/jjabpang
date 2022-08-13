package com.dongnae.jjabpang.repository;

import com.dongnae.jjabpang.entity.JjimItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JjimItemRepository extends JpaRepository<JjimItem, Long> {
      List<JjimItem> findAllByJjim_JjimNo(Long jjimNo);
      
      boolean existsAllByItem_ItemNoAndJjim_JjimNo(Long itemNo, Long JjimNo);
}