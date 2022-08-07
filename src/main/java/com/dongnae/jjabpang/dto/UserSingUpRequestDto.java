package com.dongnae.jjabpang.dto;

import com.dongnae.jjabpang.entity.User;
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
      private String email;
      private String password;
      private String username;
      private String agree_TOS;
      private String agree_PICU;
      private String gender;
      private String agree_promotion;
      private String phoneNm;
      private String del_yn;
      
      @Builder
      public UserSingUpRequestDto(String email, String password, String username, String agree_TOS, String agree_PICU, String gender, String agree_promotion, String phoneNm, String del_yn) {
            this.email = email;
            this.password = password;
            this.username = username;
            this.agree_TOS = agree_TOS;
            this.agree_PICU = agree_PICU;
            this.gender = gender;
            this.agree_promotion = agree_promotion;
            this.phoneNm = phoneNm;
            this.del_yn = del_yn;
      }
      
      public UserSingUpRequestDto(String email) {
            this.email = email;
      }
      
      public User toEntity() {
            return User.builder()
                       .email(email)
                       .password(password)
                       .nickname(username)
                       .agreeTos(agree_TOS)
                       .agreePicu(agree_PICU)
                       .gender(gender)
                       .agreePromotion(agree_promotion)
                       .phoneNm(phoneNm)
                       .delYn(del_yn)
                       .build();
      }
      
      public User toEntity_email() {
            return User.builder()
                       .email(email)
                       .build();
      }
}
