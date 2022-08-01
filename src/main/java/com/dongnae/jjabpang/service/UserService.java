package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
      
      private final UserRepository userRepository;
      
      public List<User> findAll() {
            return userRepository.findAll();
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
            user.setPassword(dto.getPassword());
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
      @Transactional
      public void delete(Integer id) {
            userRepository.deleteUserByUserNo(id);
      }
      
}
