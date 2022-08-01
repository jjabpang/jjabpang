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
@AllArgsConstructor
@Builder
public class UserSingUpDto {
      private String u_email;
      private String password;
      private String username;
      private String agree_TOS;
      private String agree_PICU;
      private String agree_promotion;
      private String phone_nm;
      
      /*DTO -> ENTITY*/
      public User toEntity() {
            return User.builder()
                       .email(u_email)
                       .password(password)
                       .nickname(username)
                       .agreeTos(agree_TOS)
                       .agreePicu(agree_PICU)
                       .agreePromotion(agree_promotion)
                       .phoneNm(phone_nm)
                       .build();
      }
}
