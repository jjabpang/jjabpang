package com.dongnae.jjabpang.repository.querydsl.user;
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
      
      @Query(name = "사용자 실명과 이메일로 비밀번호를 검색합니다.")
      String findPwdByUsernameAndEmail(String username, String email);
}
