package com.dongnae.jjabpang.dto;

import com.dongnae.jjabpang.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.dongnae.jjabpang.dto
 * fileName       : UserSingUpDto
 * author         : jihye94
 * date           : 2022-07-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-31        jihye94       최초 생성
 */
@Data
@NoArgsConstructor
public class UserSingUpRequestDto {
      private String u_email;
      private String password;
      private String username;
      private String agree_TOS;
      private String agree_PICU;
      private String agree_promotion;
      private String phone_nm;
      
      
      @Builder
      public UserSingUpRequestDto(String u_email, String password, String username, String agree_TOS, String agree_PICU, String agree_promotion, String phone_nm) {
            this.u_email = u_email;
            this.password = password;
            this.username = username;
            this.agree_TOS = agree_TOS;
            this.agree_PICU = agree_PICU;
            this.agree_promotion = agree_promotion;
            this.phone_nm = phone_nm;
      }
}
