package com.dongnae.jjabpang.repository.item;

import com.dongnae.jjabpang.entity.Category;
import com.dongnae.jjabpang.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
      Optional<Item> findItemsByCategoryOrderByCdtDesc(Category category);
      
}