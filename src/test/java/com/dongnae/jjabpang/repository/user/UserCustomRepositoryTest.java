package com.dongnae.jjabpang.repository.user;

import com.dongnae.jjabpang.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserCustomRepositoryTest {
      
      @Autowired
      UserCustomRepository userCustomRepository;
      @Autowired
      UserRepository userRepository;
      
      
      @Test
      void findOne() {
      
      }
      
      @Test
      public void save() throws Exception {
            //given
            User user = new User();
            user.setEmail("qkrtkdwn3410");
            user.setPhoneNm("1010101010");
            user.setPassword("1010101010");
            userRepository.save(user);
            
            //when
            User findUser = userRepository.findByEmail(user.getEmail());
            
            //then
            
            assertThat(user.getEmail()).isEqualTo(findUser.getEmail());
      }
}