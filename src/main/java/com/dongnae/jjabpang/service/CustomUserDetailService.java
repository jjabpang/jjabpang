package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 *packageName    : com.dongnae.jjabpang.service
 * fileName       : CustomUserDetailService
 * author         : ipeac
 * date           : 2022-08-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-11        ipeac       최초 생성
 */
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
      
      private final UserRepository userRepository;
      
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return userRepository.findAllByEmail(username)
                                 .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
      }
}
