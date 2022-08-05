package com.dongnae.jjabpang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : UserListDto
 * author         : jihye94
 * date           : 2022-08-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-06        jihye94       최초 생성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDto {
      private String cdt;
      private String udt;
      private String crtBy;
      private String uptBy;
      private Long userNo;
      private String email;
      private String birth;
      private String nickname;
      private String agreeTos;
      private String agreePicu;
      private String agreePromotion;
      private String gender;
      private Role role;
      private String phoneNm;
      private String address1;
      private String address2;
}
