package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.entity.dto.UserInfoModificationDto;
import com.dongnae.jjabpang.entity.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.exception.UsernameNotFoundException;
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
            
            return userRepository.findAll();
      }
      
      
      /**
       * 회원가입 기능
       */
      @Transactional
      public Long signUp(UserSingUpRequestDto dto) {
            validateDuplicateMember(dto.getEmail());
            log.debug("dto.getEmail() = " + dto.getEmail());
            User user = dto.toEntity();
            
            userRepository.save(user);
            
            return user.getUserNo();
      }
      
      /* 중복 회원 검증*/
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
      public Integer delete(Integer id) {
            
            return userRepository.deleteUserByUserNo(id);
      }
      
      /**
       * 이메일로 조회
       */
      public Optional<User> findByEmail(String email) throws UsernameNotFoundException {
            Optional<User> findUser = userRepository.findByEmail(email);
            findUser
                  .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
            
            
            return findUser;
      }
      
      /**
       * 회원 정보 수정
       */
      @Transactional
      public Integer updateUserInfo(Long id, UserInfoModificationDto dto) {
            Optional<User> findUser = userRepository.findById(id);
            if (findUser.isEmpty()) {
                  return 0;
            }
            
            User user = findUser.get();
            user.setEmail(dto.getEmail());
            user.setNickname(dto.getUsername());
            user.setPhoneNm(dto.getPhoneNm());
            user.setPassword(dto.getNewPassword());
            
            userRepository.save(user);
            
            return 1;
      }
      
      
}
