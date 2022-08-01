package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.Role;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
      
      private static List<User> users = new ArrayList<>();
      
      private static int usersCount = 3;
      
      static {
            users.add(new User(1, "qkeqw1", "12312312", "99999", "박", "0", "0", "0", "M", Role.BUYER, "N", LocalDateTime.now(), LocalDateTime.now(), "01011111111"));
            users.add(new User(2, "qkeqw2", "12312312", "99999", "박상2", "0", "0", "0", "M", Role.BUYER, "N", LocalDateTime.now(), LocalDateTime.now(), "01011111111"));
            users.add(new User(3, "qkeqw3", "12312312", "99999", "박상3", "0", "0", "0", "M", Role.BUYER, "N", LocalDateTime.now(), LocalDateTime.now(), "01011111111"));
            
      }
      
      private final UserRepository userRepository;
      
      private final PasswordEncoder passwordEncoder;
      
      public List<User> findAll() {
            return users;
      }
      
      
      /**
       * 회원가입 기능
       */
      @Transactional
      public Integer signUp(UserSingUpRequestDto dto) {
            validateDuplicateMember(dto.getU_email());
            User user = new User();
            
            //pw salt user 저장
            user.setEmail(dto.getU_email());
            user.setGender("M");
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setAgreeTos(dto.getAgree_TOS());
            user.setAgreePicu(dto.getAgree_PICU());
            user.setAgreePromotion(dto.getAgree_promotion());
            user.setPhoneNm(dto.getPhone_nm());
            
            userRepository.save(user);
            
            return user.getUserNo();
      }
      
      private void validateDuplicateMember(String u_email) {
            User findUser = userRepository.findByEmail(u_email);
            if (findUser != null) {
                  throw new IllegalStateException("이미 존재하는 회원입니다.");
            }
      }
      
      /**
       * 회원 탈퇴 기능
       */
      public void delete(Integer id) {
            userRepository.deleteById(id);
      }
      
      
}
