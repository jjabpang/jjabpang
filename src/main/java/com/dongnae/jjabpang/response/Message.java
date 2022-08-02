package com.dongnae.jjabpang.response;
/*
 *packageName    : com.dongnae.jjabpang.response
 * fileName       : Message
 * author         : ipeac
 * date           : 2022-08-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-02        ipeac       최초 생성
 */

import lombok.Data;

@Data
public class Message {
      
      private StatusEnum status;
      private String message;
      private Object data;
      
      public Message() {
            this.status = StatusEnum.BAD_REQUEST;
            this.data = null;
            this.message = null;
      }
}
