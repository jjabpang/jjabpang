package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {
      
      private final UserRepository userRepository;
      
      public List<User> findAll() {
            List<User> userList = userRepository.findAll();
            for (User user : userList) {
                  System.out.println("user = " + user);
            }
            return userList;
      }
      
      
      /**
       * 회원가입 기능
       */
      @Transactional
      public Integer signUp(UserSingUpRequestDto dto) {
            validateDuplicateMember(dto.getEmail());
            log.debug("dto.getEmail() = " + dto.getEmail());
            User user = dto.toEntity();
            
            userRepository.save(user);
            
            return user.getUserNo();
      }
      
      private void validateDuplicateMember(String u_email) {
            Optional<User> findUser = userRepository.findByEmail(u_email);
            log.debug("findUser = " + findUser);
            if (findUser.isPresent()) {
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
