package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.UserLoginRequestDto;
import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.exception.UsernameNotFoundException;
import com.dongnae.jjabpang.repository.user.UserRepository;
import com.dongnae.jjabpang.response.Message;
import com.dongnae.jjabpang.response.StatusEnum;
import com.dongnae.jjabpang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

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
      public ResponseEntity<Message> signUp(@RequestBody UserSingUpRequestDto dto) {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
            
            // User user = dto.toEntity();
            Integer userNo = userService.signUp(dto);
            
            
            message.setStatus(StatusEnum.OK);
            message.setMessage("회원 가입 성공");
            message.setData(userNo);
            
            return new ResponseEntity<>(message, headers, HttpStatus.OK);
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
      
      @ApiOperation(value = "회원 로그인 기능")
      @PostMapping("/users/login")
      public ResponseEntity<Message> login(@RequestBody UserLoginRequestDto dto) throws UsernameNotFoundException {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
            
            User findUser = userService.findByEmail(dto.getEmail())
                                       .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 사용자 입니다."));
            if (!findUser.getPassword()
                         .equals(dto.getPassword())) {
                  throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
            }
            message.setStatus(StatusEnum.OK);
            message.setMessage("로그인 성공");
            message.setData(findUser.getUserNo());
            return new ResponseEntity<>(message, headers, HttpStatus.OK);
      }
      
      @Data
      @AllArgsConstructor
      
      static class Result<T> {
            
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
