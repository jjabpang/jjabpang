package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.Role;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.user.UserCustomRepositoryImpl;
import com.dongnae.jjabpang.repository.user.UserRepository;
import com.dongnae.jjabpang.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 *packageName    : com.dongnae.jjabpang.controller
 * fileName       : UserControllerTest
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */
@SpringBootTest
public class UserServiceTest {
      @Autowired
      UserService userService;
      
      @Autowired
      UserRepository userRepository;
      
      @Autowired
      UserCustomRepositoryImpl userCustomRepository;
      
      @Test
      @Rollback(false)
      @Transactional
      public void signUp() {
            //given
            UserSingUpRequestDto dto = new UserSingUpRequestDto();
            dto.setPhoneNm("01011111111");
            dto.setPassword("0101011010");
            dto.setEmail("qkrtkdwns3410@naver.com");
            dto.setUsername("ddd");
            dto.setAgree_TOS("0");
            dto.setAgree_PICU("0");
            dto.setAgree_promotion("0");
            
            //when
            Long saveId = userService.signUp(dto);
            
            Optional<User> findUser = userRepository.findById(saveId);
            
            System.out.println("findUser = " + findUser);
            //then
            
      }
      
      @Test
      public void duplicated_email_test() {
            UserSingUpRequestDto user1 = new UserSingUpRequestDto("qkrtkdwns3410", "1234", "1234", "0", "0", "m", "0", "01011111111", "n", LocalDateTime.now(), LocalDateTime.now());
            UserSingUpRequestDto user2 = new UserSingUpRequestDto("qkrtkdwns3410", "1234", "1234", "0", "0", "m", "0", "01011111111", "n", LocalDateTime.now(), LocalDateTime.now());
            
            userService.signUp(user1);
            IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.signUp(user2));
            
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
      }
      
      @Test
      void findAll() {
            User user = new User(1, "qkrtkdwns3410@navber", "1234", "951103", "박", "0", "0", "0", "m", Role.b, "n", LocalDateTime.now(), LocalDateTime.now(), "01011111111");
            User user2 = new User(2, "qkrtkdwns3410@navber", "1234", "951103", "박", "0", "0", "0", "m", Role.b, "n", LocalDateTime.now(), LocalDateTime.now(), "01011111111");
            
            userRepository.save(user);
            userRepository.save(user2);
            
            List<User> findMember = userService.findAll();
            for (User user1 : findMember) {
                  System.out.println("user = " + user1);
            }
      }
      
      @Test
      void delete() {
      }
}
