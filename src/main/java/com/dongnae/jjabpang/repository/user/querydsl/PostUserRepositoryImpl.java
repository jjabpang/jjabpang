package com.dongnae.jjabpang.repository.user.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.dongnae.jjabpang.entity.QUser.user;

/*
 *packageName    : com.dongnae.jjabpang.repository.user.querydsl
 * fileName       : PostUserRepositoryImpl
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */
@Repository
@RequiredArgsConstructor
public class PostUserRepositoryImpl implements PostUserRepository {
      
      private final JPAQueryFactory qf;
      
      @Override
      public String findEmailByPhoneNm(String phoneNm) {
            
            return qf.select(user.email)
                     .from(user)
                     .where(user.phoneNm.eq(phoneNm))
                     .fetchOne();
      }
      
      @Override
      public String findPwdByUsernameAndEmail(String username, String email) {
            
            return qf.select(user.password)
                     .from(user)
                     .where(user.nickname.eq(username), user.email.eq(email))
                     .fetchOne();
      }
}
