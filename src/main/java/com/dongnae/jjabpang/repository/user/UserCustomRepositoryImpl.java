package com.dongnae.jjabpang.repository.user;

import com.dongnae.jjabpang.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/*
 *packageName    : com.dongnae.jjabpang.repository
 * fileName       : CustomUserRepository
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */
@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCustomRepositoryImpl implements UserCustomRepository {
      private final EntityManager em;
      
      @Override
      public User findOne(Integer id) {
            return em.find(User.class, id);
      }
}
