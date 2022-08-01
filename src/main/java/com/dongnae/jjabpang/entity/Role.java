package com.dongnae.jjabpang.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * packageName    : com.dongnae.jjabpang.entity
 * fileName       : Role
 * author         : jihye94
 * date           : 2022-07-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-31        jihye94       최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum Role {
      USER("ROLE_USER"),
      ADMIN("ROLE_ADMIN");
      
      private final String value;
}
