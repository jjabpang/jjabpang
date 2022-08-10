package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.config.JwtTokenProvider;
import com.dongnae.jjabpang.dto.UserInfoModificationDto;
import com.dongnae.jjabpang.dto.UserListDto;
import com.dongnae.jjabpang.dto.UserSingUpRequestDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.exception.UsernameNotFoundException;
import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {
      
      private final ModelMapper modelMapper;
      private final UserRepository userRepository;
      private final PasswordEncoder passwordEncoder;
      private final JwtTokenProvider jwtTokenProvider;
      
      
      public List<UserListDto> findAll() {
            List<User> result = userRepository.findAll();
            List<UserListDto> result2 = new ArrayList<>();
            for (User user : result) {
                  UserListDto userListDto = modelMapper.map(user, UserListDto.class);
                  result2.add(userListDto);
            }
            return result2;
      }
      
      
      /**
       * 회원가입 기능
       */
      @Transactional
      public Long signUp(UserSingUpRequestDto dto) {
            validateDuplicateMember(dto.getEmail());
            log.debug("dto.getEmail() = " + dto.getEmail());
            User user = dto.toEntity();
            //암호화 된 비밀번호 저장
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setRoles(Collections.singletonList("ROLE_USER"));
            userRepository.save(user);
            
            return user.getUserNo();
      }
      
      /* 중복 회원 검증*/
      private void validateDuplicateMember(String u_email) {
            Optional<User> findUser = userRepository.findAllByEmail(u_email);
            log.debug("findUser = " + findUser);
            if (findUser.isPresent()) {
                  throw new IllegalStateException("이미 존재하는 회원입니다.");
            }
      }
      
      /**
       * 회원 탈퇴 기능 ( del_yn 'n' -> 'y' )
       */
      @Transactional
      public Long delete(Long id) {
            User findUser = userRepository.findById(id)
                                          .orElseThrow(EntityNotFoundException::new);
            
            //변경 감지 -> 탈퇴 회원으로 변경
            findUser.setDelYn("y");
            
            return findUser.getUserNo();
      }
      
      /**
       * 이메일로 조회
       */
      public Optional<User> findByEmail(String email) throws UsernameNotFoundException {
            Optional<User> findUser = userRepository.findAllByEmail(email);
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
      
      /**
       * Security & JWT 용 함수
       */
      public Optional<User> findByIdPw(Long id) {
            return userRepository.findById(id);
      }
      
}
