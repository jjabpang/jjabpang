package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.DefaultResponseDTO;
import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * packageName    : com.dongnae.jjabpang.controller
 * fileName       : UserController
 * author         : jihye94
 * date           : 2022-07-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-31        jihye94       최초 생성
 */
@RequestMapping("/api/user/")
@RestController
@Slf4j
public class UserController {
      
      @Autowired
      private UserService userService;
      
      
      /**
       * 회원가입 기능
       */
      @PostMapping("/sign-up")
      public void signUp(@RequestBody User user) {
      
      }
      
      /**
       * 회원 목록 조회
       */
      @GetMapping("/users")
      public List<User> retrieveAllUsers() {
            return userService.findAll();
      }
      
      @Data
      @AllArgsConstructor
      class Result<T> {
            
            private T data;
            
      }
      
      @Data
      static class UserSingUpResponseDto {
            private Integer id;
            
            public UserSingUpResponseDto(Integer id) {
                  this.id = id;
            }
      }
}
