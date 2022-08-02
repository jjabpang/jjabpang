package com.dongnae.jjabpang.repository.user.querydsl;
/*
 *packageName    : com.dongnae.jjabpang.repository.user.querydsl
 * fileName       : PostUserRepository
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */


import org.springframework.data.jpa.repository.Query;

public interface PostUserRepository {
      @Query(name = "핸드폰 번호로 이메일을 가져옵니다.")
      String findEmailByPhoneNm(String phoneNm);
      
      String findPwdByUsernameAndEmail(String username, String email);
}
