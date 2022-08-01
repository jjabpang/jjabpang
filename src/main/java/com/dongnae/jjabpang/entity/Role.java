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
      BUYER("B", "구매자"),
      SELLER("S", "판매자"),
      MANGER("M", "관리자");
      
      private String code;
      private String name;
      
      Role(String code, String name) {
            this.code = code;
            this.name = name;
      }
      
}
