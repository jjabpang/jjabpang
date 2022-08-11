package com.dongnae.jjabpang.entity;
/*
 *packageName    : com.dongnae.jjabpang.entity
 * fileName       : Role
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */

import lombok.Getter;

@Getter
public enum Role {
      b("ROLE_USER", "구매자"),
      m("ROLE_ADMIN", "관리자");
      
      private String code;
      private String name;
      
      Role(String code, String name) {
            this.code = code;
            this.name = name;
      }
      
}
