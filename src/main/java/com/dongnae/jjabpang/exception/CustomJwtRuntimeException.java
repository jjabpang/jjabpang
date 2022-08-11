package com.dongnae.jjabpang.exception;
/*
 *packageName    : com.dongnae.jjabpang.exception
 * fileName       : CustomJwtRuntimeException
 * author         : ipeac
 * date           : 2022-08-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-11        ipeac       최초 생성
 */

public class CustomJwtRuntimeException extends Throwable {
      public CustomJwtRuntimeException(String message) {
            super(message);
      }
}
