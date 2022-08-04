package com.dongnae.jjabpang.entity.dto;

import lombok.Getter;

/*
 *packageName    : com.dongnae.jjabpang.dto
 * fileName       : UserInfoModificationDto
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */
@Getter
public class UserInfoModificationDto {
      private String email;
      private String username;
      private String phoneNm;
      private String password;
      private String newPassword;
      
}
