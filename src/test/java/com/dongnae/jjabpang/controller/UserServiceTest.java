package com.dongnae.jjabpang.controller;

import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.user.UserCustomRepositoryImpl;
import com.dongnae.jjabpang.repository.user.UserRepository;
import com.dongnae.jjabpang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
@Transactional(readOnly = true)
public class UserServiceTest {
      @Autowired
      UserService userService;
      
      @Autowired
      UserRepository userRepository;
      
      @Autowired
      UserCustomRepositoryImpl userCustomRepository;
      
      @Test
      public void signUp() throws Exception {
            //given
            UserSingUpRequestDto dto = new UserSingUpRequestDto();
            dto.setPhone_nm("01011111111");
            dto.setPassword("0101011010");
            dto.setU_email("qkrtkdwns3410@naver.com");
            dto.setUsername("ddd");
            dto.setAgree_TOS("0");
            dto.setAgree_PICU("0");
            dto.setAgree_promotion("0");
            
            //when
            Integer saveId = userService.signUp(dto);
            
            Optional<User> findUser = userRepository.findById(saveId);
            
            System.out.println("findUser = " + findUser);
            //then
            
      }
      
      @Test
      void findAll() {
            List<User> findMember = userService.findAll();
            for (User user : findMember) {
                  System.out.println("user = " + user);
            }
      }
      
      @Test
      void delete() {
      }
}
