package com.dongnae.jjabpang.repository.user;

import com.dongnae.jjabpang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
      User findByEmail(String email);
      
}