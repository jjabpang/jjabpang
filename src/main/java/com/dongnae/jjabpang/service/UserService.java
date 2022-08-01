package com.dongnae.jjabpang.service;

import com.dongnae.jjabpang.dto.UserSingUpDto;
import com.dongnae.jjabpang.entity.User;
import com.dongnae.jjabpang.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
      
      @Autowired
      private UserRepository userRepository;
      
      /**
       * 회원가입 기능
       */
      public Integer save(UserSingUpDto dto) {
            User bean = new User();
            BeanUtils.copyProperties(dto, bean);
            bean = userRepository.save(bean);
            return bean.getUserNo();
      }
      
      public void delete(Integer id) {
            userRepository.deleteById(id);
      }
      
}
