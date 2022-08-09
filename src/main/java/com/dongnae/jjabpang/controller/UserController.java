package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.UserDeliveryDto;
import com.dongnae.jjabpang.dto.UserInfoModificationDto;
import com.dongnae.jjabpang.dto.UserLoginRequestDto;
import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.exception.UsernameNotFoundException;
import com.dongnae.jjabpang.repository.querydsl.user.QUserRepository;
import com.dongnae.jjabpang.response.Message;
import com.dongnae.jjabpang.response.StatusEnum;
import com.dongnae.jjabpang.service.DeliveryService;
import com.dongnae.jjabpang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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
      private final QUserRepository qUserRepository;
      private final DeliveryService deliveryService;
      
      /**
       * 회원가입 기능
       */
      @ApiOperation(value = "회원 가입")
      @PostMapping("/users")
      public ResponseEntity<Message> signUp(@RequestBody UserSingUpRequestDto dto) {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
            // User user = dto.toEntity();
            Long userNo = userService.signUp(dto);
            
            
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
      @ApiImplicitParam(name = "userNo", dataTypeClass = Long.class, value = "회원 번호", paramType = "query", required = true)
      @PostMapping("/users/{userNo}")
      public ResponseEntity<Message> deleteUser(@PathVariable Long userNo) {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
            Long deletedUserNo = userService.delete(userNo);
            
            message.setStatus(StatusEnum.OK);
            message.setMessage("회원 탈퇴 성공 , data : 탈퇴된 회원번호");
            message.setData(deletedUserNo);
            
            return new ResponseEntity<>(message, headers, HttpStatus.OK);
      }
      
      @ApiOperation(value = "회원 로그인 기능")
      @PostMapping("/users/login")
      public ResponseEntity<Message> login(@ApiParam(value = "로그인 요청 DTO") @RequestBody UserLoginRequestDto dto) throws UsernameNotFoundException {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
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
      
      @ApiOperation(value = "회원 정보 수정")
      @ApiImplicitParam(name = "userNo", dataTypeClass = Long.class, value = "회원 번호", paramType = "query", required = true)
      @PutMapping("/users/{userNo}")
      public ResponseEntity<Message> modify(@PathVariable Long userNo, @RequestBody UserInfoModificationDto dto) {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
            Integer affectedRow = userService.updateUserInfo(userNo, dto);
            if (affectedRow == 0) {
                  throw new IllegalArgumentException("회원정보 수정 실패");
            } else {
                  message.setStatus(StatusEnum.OK);
                  message.setMessage("회원정보 수정 성공 | (Data) 반영된 행수");
                  message.setData(affectedRow);
            }
            
            return new ResponseEntity<>(message, headers, HttpStatus.OK);
      }
      
      @ApiOperation(value = "등록된 휴대폰 번호로 이메일 찾기")
      @PostMapping("/users/find-email")
      public Result findEmail(@RequestBody Map<String, String> phoneNum) {
            
            Map<String, String> resultMap = new HashMap<>();
            
            String email = qUserRepository.findEmailByPhoneNm(phoneNum.get("phoneNum"));
            
            if (email == null) {
                  throw new IllegalStateException("등록된 이메일이 없습니다");
            }
            
            resultMap.put("email", email);
            return new Result(resultMap);
      }
      
      @ApiOperation(value = "이름과 이메일로 비밀번호 찾기 - 임시 비밀번호 전송으로 변경해야할 것 같음")
      @PostMapping("/users/find-pwd")
      public Result findPwd(@RequestBody UsernameAndEmailDto dto) {
            Map<String, String> resultMap = new HashMap<>();
            
            String pwd = qUserRepository.findPwdByUsernameAndEmail(dto.getUsername(), dto.getEmail());
            
            if (pwd == null) {
                  throw new IllegalStateException("등록된 이메일 혹은 이름이 없습니다.");
            }
            
            resultMap.put("pwd", pwd);
            return new Result(resultMap);
      }
      
      @ApiOperation(value = "회원 배송지 추가")
      @PostMapping("/users/add-cart")
      public ResponseEntity<Message> addCart(@RequestBody UserDeliveryDto userDeliveryDto) throws Exception {
            Message message = new Message();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            
            Long deliveryNo = deliveryService.addDelivery(userDeliveryDto);
            
            message.setStatus(StatusEnum.OK);
            message.setData(deliveryNo);
            message.setMessage("배송지 등록 성공, 배송지 리턴");
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
      
      @Getter
      static class UsernameAndEmailDto {
            private String username;
            private String email;
      }
}
