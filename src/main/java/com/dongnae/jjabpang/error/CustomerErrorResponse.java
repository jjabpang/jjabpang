package com.dongnae.jjabpang.error;

import lombok.Data;

/*
 *packageName    : com.dongnae.jjabpang.error
 * fileName       : CustomerErrorResponse
 * author         : ipeac
 * date           : 2022-08-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-01        ipeac       최초 생성
 */
@Data
public class CustomerErrorResponse {
      private int statusCode;
      private String message;
      private long timeStamp;
}
