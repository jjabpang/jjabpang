package com.dongnae.jjabpang.dto.user;

import lombok.Getter;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : UserLoginRequestDto
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */
@Getter
public class UserLoginRequestDto {
      private String email;
      private String password;
}
