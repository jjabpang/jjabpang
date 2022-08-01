package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.UserSingUpDto;
import com.dongnae.jjabpang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
      @Autowired
      private UserService userService;
      
      
      /**
       * 회원가입 기능
       */
      public String singUp(UserSingUpDto dto) {
            Integer singUpId = userService.save(dto);
            
            return singUpId;
      }
}
