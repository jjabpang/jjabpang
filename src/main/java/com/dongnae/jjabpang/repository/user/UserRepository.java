package com.dongnae.jjabpang.repository.user;

import com.dongnae.jjabpang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
      Optional<User> findAllByEmail(String email);
      
      List<User> findAll();
      
      Integer deleteUserByUserNo(Long userNo);
      
      User findByUserNo(Long userNo);
      
      User findByEmail(String email);
      
}