package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.user.UserRepository;
import com.dongnae.jjabpang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
@RequiredArgsConstructor
@Api(tags = "회원")
public class UserController {
      
      private final UserService userService;
      private final UserRepository userRepository;
      
      
      /**
       * 회원가입 기능
       */
      @ApiOperation(value = "회원 가입")
      @PostMapping("/users")
      public Integer signUp(@RequestBody UserSingUpRequestDto dto) {
//            User user = dto.toEntity();
            
            return userService.signUp(dto);
      }
      
      /**
       * 회원 목록 조회
       */
      @ApiOperation(value = "회원 전체 목록 조회")
      @GetMapping("/users")
      public Result retrieveAllUsers() {
            return new Result(userService.findAll());
      }
      
      /**
       * 회원 탈퇴 기능
       */
      @ApiOperation(value = "회원 탈퇴 기능")
      @DeleteMapping("/users/{id}")
      public void deleteUser(@PathVariable int id) {
            userService.delete(id);
            
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
