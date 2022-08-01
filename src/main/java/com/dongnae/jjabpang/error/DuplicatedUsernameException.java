package com.dongnae.jjabpang.error;
/*
 *packageName    : com.dongnae.jjabpang.error
 * fileName       : DuplicatedUsernameException
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */


public class DuplicatedUsernameException extends RuntimeException {
      
      public DuplicatedUsernameException(String message, Throwable cause) {
            super(message, cause);
      }
      
      public DuplicatedUsernameException(String message) {
            super(message);
      }
      
      public DuplicatedUsernameException(Throwable cause) {
            super(cause);
      }
      
}
