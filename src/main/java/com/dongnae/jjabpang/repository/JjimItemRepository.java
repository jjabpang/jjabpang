package com.dongnae.jjabpang.repository;

import com.dongnae.jjabpang.entity.JjimItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JjimItemRepository extends JpaRepository<JjimItem, Long> {

}