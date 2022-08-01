package com.dongnae.jjabpang.repository.user;
/*
 *packageName    : com.dongnae.jjabpang.repository
 * fileName       : UserCustomRepository
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */


import com.dongnae.jjabpang.entity.User;

public interface UserCustomRepository {
      
      User findOne(Integer id);
}
