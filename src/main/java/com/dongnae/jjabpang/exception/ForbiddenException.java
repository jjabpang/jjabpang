package com.dongnae.jjabpang.exception;
/*
 *packageName    : com.dongnae.jjabpang.exception
 * fileName       : ForbiddenException
 * author         : ipeac
 * date           : 2022-08-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-11        ipeac       최초 생성
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
      
      public ForbiddenException(String message) {
            super(message);
      }
      
}

